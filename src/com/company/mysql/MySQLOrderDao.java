package com.company.mysql;

import com.company.dao.OrderDao;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ira on 02.02.2016.
 */
public class MySQLOrderDao extends CommonDao implements OrderDao {


    public MySQLOrderDao() {
        super();
    }

    public Order findById() {
        return null;
    }

    public List<Order> findAll() {
        return null;
    }

    // add new order
    public void save(Order order) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int id = getNextId("order");
            order.setId(id);
            int isPaid = 0;
            if (order.isPaid()) {
                isPaid = 1;
            }
            String sql = "insert into `order` values (" + id + " , " + order.getIdUser() + " , " + order.getIdProduct() + " , " + order.getNumber() + " , " + isPaid + ")";
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement);
        }


    }


    public List<Order> findByIdUser(int idUser) {
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,idProduct,number,isPaid FROM `order` where idUser = " + idUser;
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setIdUser(resultSet.getInt("idUser"));
                order.setIdProduct(resultSet.getInt("idProduct"));
                order.setNumber(resultSet.getInt("number"));
                if (resultSet.getInt("isPaid") == 1) {
                    order.setIsPaid(true);
                }
                orderList.add(order);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return orderList;
    }

    public void delete(int idOrder){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "delete from `order` where id = " + idOrder;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement);
        }
    }

}
