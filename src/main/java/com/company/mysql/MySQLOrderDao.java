package com.company.mysql;

import com.company.dao.OrderDao;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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

    public final Logger log = LogManager.getLogger(MySQLOrderDao.class);
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
            String sql = "SELECT idUser,idProduct,number,isPaid FROM `order` where id = " + idOrder;
            log.debug(sql);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                order.setId(idOrder);
                order.setIdUser(resultSet.getInt("idUser"));
                order.setIdProduct(resultSet.getInt("idProduct"));
                order.setNumber(resultSet.getInt("number"));
                if (resultSet.getInt("isPaid") == 1) {
                    order.setIsPaid(true);
                }
            }

        } catch (SQLException e) {
            log.error(e);

        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }

        return order;
    }

    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,idUser,idProduct,number,isPaid FROM `order`";
            log.debug(sql);
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
            log.error(e);
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return orderList;
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
            log.debug(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            log.error(e);
           // e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement);
        }
        return id;

    }

    /**
     * Find order by id User
     * @param idUser ID User
     * @return List of user orders
     */
    public List<Order> findByIdUser(int idUser) {
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,idProduct,number,isPaid FROM `order` where idUser = " + idUser;
            log.debug(sql);
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
            log.error(e);
           // e.printStackTrace();
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
            String sql = "delete from `order` where id = " + idOrder;
            log.debug(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            log.error(e);
          //  e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement);
        }
    }

    /**
     * Update column "isPaid" in order table
     * @param idOrder
     * @param isPaid
     */
    public  void updateInfo(int idOrder, int isPaid){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "update `order` set isPaid = " + isPaid + " where id = " + idOrder;
            log.debug(sql);
            // System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            log.error(e);
          //  e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement);
        }

    }

    /**
     * Find the orders, which the user has not paid
     * @param idUser
     * @return
     */
    public List<Order> findOrderByIdUserPaid(int idUser, int isPaid){
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,idProduct,number FROM `order` where idUser = " + idUser + " and isPaid = " + isPaid;
            log.debug(sql);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setIdUser(idUser);
                order.setIdProduct(resultSet.getInt("idProduct"));
                order.setNumber(resultSet.getInt("number"));
                order.setIsPaid(false);
                orderList.add(order);

            }
        } catch (SQLException e) {
            log.error(e);
          //  e.printStackTrace();
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return orderList;
    }

}
