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

    public Order findById(int idOrder) {
        Order order = new Order();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,idProduct,number FROM `order` where id = " + idOrder;
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                order.setId(resultSet.getInt("id"));
                order.setIdUser(resultSet.getInt("idUser"));
                order.setIdProduct(resultSet.getInt("idProduct"));
                order.setNumber(resultSet.getInt("number"));
                if (resultSet.getInt("isPaid") == 1) {
                    order.setIsPaid(true);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }

        return order;
    }

    public List<Order> findAll() {
        return null;
    }

    /**
     * Add new order to database
     * @param order
     */
    public int save(Order order) {
        Connection connection = null;
        Statement statement = null;
        int id = 0;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            id = getNextId("order");
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
        return id;

    }

    /**
     * Find order by id User
     * @param idUser
     * @return
     */
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
                order.setIdUser(idUser);
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

    /**
     * Delete order by id
     * @param idOrder
     */
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

    public  void updateInfo(int idOrder, int isPaid){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "update `order` set isPaid = " + 1 + " where id = " + idOrder;
            // System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement);
        }

    }

}
