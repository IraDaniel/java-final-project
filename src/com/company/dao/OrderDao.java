package com.company.dao;

import com.company.entity.Order;

import java.util.List;

/**
 * Created by Ira on 02.02.2016.
 */
public interface OrderDao {

    public Order findById(int idOrder);
    List<Order> findAll();

    int save(Order order);

    List<Order> findByIdUser(int idUser);

    void delete(int idOrder);

    void updateInfo(int idOrder, int isPaid);


}
