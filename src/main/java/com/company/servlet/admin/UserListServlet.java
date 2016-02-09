package com.company.servlet.admin;

import com.company.entity.Order;
import com.company.entity.User;
import com.company.mysql.MySQLOrderDao;
import com.company.mysql.MySQLProductDao;
import com.company.mysql.MySQLUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ira on 08.02.2016.
 */

/*
* Show all users and their debts
* */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    MySQLUserDao mySQLUserDao;
    MySQLProductDao mySQLProductDao;
    MySQLOrderDao mySQLOrderDao;

    public UserListServlet() {
        super();
        mySQLUserDao = new MySQLUserDao();
        mySQLOrderDao = new MySQLOrderDao();
        mySQLProductDao = new MySQLProductDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = mySQLUserDao.findAll();
        List<Double> debtList = new ArrayList<>();
        double debt = 0.0;

        for (User user : userList) {
            List<Order> orderList = mySQLOrderDao.findOrderByIdUserPaid(user.getId(), 0);

            for (Order order : orderList) {
                debt += (mySQLProductDao.findById(order.getIdProduct()).getPrice() * order.getNumber());
            }
            debtList.add(debt);
            debt = 0;

        }
        request.setAttribute("debts", debtList);
        request.setAttribute("users", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/page/admin/userList.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);

        }


    }
}
