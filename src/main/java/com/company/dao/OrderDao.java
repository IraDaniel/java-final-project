package com.company.dao;

import com.company.entity.Order;

import java.util.List;

/**
 * Created by Ira on 02.02.2016.
 */
public interface OrderDao {

    /**
     * Find order by ID
     * @param idOrder
     * @return
     */
    Order findById(int idOrder);

    /**
     *
     * @return
     */
    List<Order> findAll();

    int save(Order order);

    List<Order> findByIdUser(int idUser);

    void delete(int idOrder);

    void updateInfo(int idOrder, int isPaid);

    public List<Order> findOrderByIdUserPaid(int idUser, int isPaid);


}
