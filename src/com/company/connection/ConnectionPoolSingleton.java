package com.company.connection;

/**
 * Created by Ira on 03.02.2016.
 */
public class ConnectionPoolSingleton {

    private static ConnectionPoolSingleton instance = null;

    private ConnectionPool connectionPool;

    private ConnectionPoolSingleton() {
        connectionPool = new ConnectionPool();
        connectionPool.initPoolData();
    }

    public static synchronized ConnectionPoolSingleton getInstance() {
        if(instance == null) {
            instance =  new ConnectionPoolSingleton();
        }
        return instance;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
