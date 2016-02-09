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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ira on 08.02.2016.
 */

/**
 * Get orders by ID user
 */
@WebServlet("/UserOrdersServlet")
public class UserOrdersServlet extends HttpServlet {

    MySQLOrderDao mySQLOrderDao;
    MySQLUserDao mySQLUserDao;

    public UserOrdersServlet() {
        super();
        mySQLOrderDao = new MySQLOrderDao();
        mySQLUserDao = new MySQLUserDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameterValues("id")[0]);
        //HttpSession session = request.getSession();
      // User user = (User)session.getAttribute("user");

        List<Order> orderList = mySQLOrderDao.findByIdUser(id);
        User user = mySQLUserDao.findById(id);
        request.setAttribute("orders",orderList);
        request.setAttribute("user",user);
      //  request.setAttribute("name",user.getNameSurname());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/page/admin/userOrders.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }


    }
}
