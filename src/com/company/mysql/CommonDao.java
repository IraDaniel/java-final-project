package com.company.mysql;

import com.company.connection.ConnectionPool;
import com.company.connection.ConnectionPoolSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ira on 03.02.2016.
 */
public class CommonDao {
    protected ConnectionPool cp;

    public CommonDao() {
        this.cp = ConnectionPoolSingleton.getInstance().getConnectionPool();
    }

    protected int getNextId(String tableName) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int nextId = 0;
        try {
            connection = cp.takeConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT id FROM `" + tableName + "`";
            resultSet = statement.executeQuery(query);
            if(resultSet.last()){
                nextId = resultSet.getInt("id") + 1;
            }else{
                nextId = 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.closeConnection(connection,statement,resultSet);

        }
        return nextId;
    }
}
