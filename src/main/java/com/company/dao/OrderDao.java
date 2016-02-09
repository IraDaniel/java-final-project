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
     * Find all orders
     * @return list of orders
     */
    List<Order> findAll();

    /**
     * Save new order
     * @param order
     * @return ID prder
     */
    int save(Order order);

    /**
     * Find order by ID user
     * @param idUser
     * @return
     */
    List<Order> findByIdUser(int idUser);

    /**
     * Delete order by ID
     * @param idOrder
     */
    void delete(int idOrder);

    /**
     * Update information about order by ID
     * @param idOrder
     * @param isPaid
     */
    void updateInfo(int idOrder, int isPaid);

    /**
     * Find order by ID user and param isPaid
     * If isPaid = 0, then find unpaid order by ID user
     * If isPaid = 1, then find paid   order by ID user
     * @param idUser
     * @param isPaid
     * @return
     */
    List<Order> findOrderByIdUserPaid(int idUser, int isPaid);


}
