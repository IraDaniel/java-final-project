package com.company.mysql;

import com.company.dao.ProductDao;
import com.company.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ira on 29.01.2016.
 */
public class MySQLProductDao extends CommonDao implements ProductDao{


    public MySQLProductDao() {
      super();
    }

    public List<Product> findAll(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,name,price FROM product ";
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.closeConnection(connection,statement,resultSet);
        }


        return products;
    }

    public Product findById(int id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Product product = new Product();
        try {
            connection = cp.takeConnection();
            String sql = "SELECT id,name,price FROM product where id = " + id;
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
            if(resultSet.first()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.closeConnection(connection,statement,resultSet);
        }
        return product;
    }




}
