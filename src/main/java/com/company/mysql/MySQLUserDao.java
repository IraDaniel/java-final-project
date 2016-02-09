package com.company.mysql;

import com.company.dao.UserDao;
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
 * Created by Ira on 29.01.2016.
 */
public class MySQLUserDao extends CommonDao implements UserDao {

    public final Logger log = LogManager.getLogger(MySQLUserDao.class);
    public MySQLUserDao() {
        super();
    }

    public User findById(int id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT name,surname,login,isBlack FROM user where id = " + id;
            log.debug(sql);
            resultSet = statement.executeQuery(sql);
            if(resultSet.first()){
                user.setId(id);
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                if (resultSet.getInt("isBlack") == 1) {
                    user.setIsBlack(true);
                } else {
                    user.setIsBlack(false);
                }
            }

        } catch (SQLException e) {
            log.error(e);
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return user;
    }

    public int save(User user) {
        Connection connection = null;
        Statement statement = null;
        int id = 0;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            id = getNextId("user");
            user.setId(id);
            int isBlack = 0;
            if (user.isBlack()) isBlack = 1;
            String sql = "insert into user values (" + id + ", '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getLogin() + "', '" + user.getPassword() + "', " + isBlack + ")";
            log.debug(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
          //  e.printStackTrace();
            log.error(e);
        } finally {

            cp.closeConnection(connection, statement);
        }
        return id;

    }

    /**
     * Get all users in table: User
     * @return
     */

    public List<User> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT id,name,surname,login,isBlack FROM user ";
            log.debug(sql);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                if (resultSet.getInt("isBlack") == 1) {
                    user.setIsBlack(true);
                } else {
                    user.setIsBlack(false);
                }
                userList.add(user);
            }


        } catch (SQLException e) {
         //   e.printStackTrace();
            log.error(e);
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return userList;
    }

    public User findByLoginPass(String login, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,name,surname,isBlack FROM user where login = '" + login + "' and password = '" + password + "'";
            log.debug(sql);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
            if (resultSet.first()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(login);
                user.setPassword(password);
                if (resultSet.getInt("isBlack") == 1) {
                    user.setIsBlack(true);
                } else {
                    user.setIsBlack(false);
                }
            }


        } catch (SQLException e) {
          //  e.printStackTrace();
            log.error(e);
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return user;
    }


    public List<User> listBlackUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,name,surname,login FROM user where isBlack = 1";
            log.debug(sql);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setLogin(resultSet.getString("login"));
                user.setIsBlack(true);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
          //  e.printStackTrace();
            log.error(e);
        } finally {
            cp.closeConnection(connection, statement, resultSet);
        }
        return userList;
    }

    // update user set isBlack = 1 where id = idUser
    public void updateInfo(int idUser, int isBlack) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "update user set isBlack = " + isBlack + " where id = " + idUser;
            log.debug(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
          //  e.printStackTrace();
            log.error(e);
        } finally {
            cp.closeConnection(connection, statement);
        }
    }

}
