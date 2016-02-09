package com.company.dao;

import com.company.entity.Product;

import java.util.List;

/**
 * Created by Ira on 29.01.2016.
 */
public interface ProductDao {


    /**
     * Find product by ID
     * @param id ID product
     * @return
     */
    Product findById(int id);

    /**
     * Find all products
     * @return list of products
     */
    List<Product> findAll();

}
