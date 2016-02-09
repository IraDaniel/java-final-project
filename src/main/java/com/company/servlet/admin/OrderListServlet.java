package com.company.servlet.admin;

import com.company.entity.Order;
import com.company.mysql.MySQLOrderDao;
import com.company.mysql.MySQLProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Show all orders
 */

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
    MySQLOrderDao mySQLOrderDao;

    public OrderListServlet() {
        super();
        mySQLOrderDao = new MySQLOrderDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList = mySQLOrderDao.findAll();

        request.setAttribute("orders", orderList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/page/admin/adminPage.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
