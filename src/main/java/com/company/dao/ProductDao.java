package com.company.dao;

import com.company.entity.Product;

import java.util.List;

/**
 * Created by Ira on 29.01.2016.
 */
public interface ProductDao {

    Product findById(int id);

    List<Product> findAll();

}
