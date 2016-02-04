package com.company.dao;

import com.company.entity.Order;

import java.util.List;

/**
 * Created by Ira on 02.02.2016.
 */
public interface OrderDao {

    Order findById();
    List<Order> findAll();

    void save(Order order);

    List<Order> findByIdUser(int idUser);

    void delete(int idOrder);


}
