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
public class MySQLProductDao implements ProductDao{
    private Connection connection;
    private Statement statement;

    public MySQLProductDao(Connection connection) {
        this.connection = connection;

    }

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT id,name,price FROM product ";
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           // statement.
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }


        return products;
    }

    public Product findById(int id){
        Product product = new Product();
        return product;
    }




}
