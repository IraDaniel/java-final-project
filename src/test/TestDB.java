package test;

import com.company.connection.ConnectionPool;
import com.company.entity.Product;
import com.company.mysql.MySQLProductDao;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Ira on 29.01.2016.
 */
public class TestDB {
    @Test
    public void testDB(){

        ConnectionPool cp = new ConnectionPool();
        cp.initPoolData();
        Connection connection = cp.takeConnection();
        MySQLProductDao mySQLProductDao = new MySQLProductDao(connection);
        List<Product> products =  mySQLProductDao.findAll();
        cp.closeConnection(connection);

    }
}


