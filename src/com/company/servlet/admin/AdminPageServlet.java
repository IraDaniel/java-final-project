package com.company.servlet.admin;

import com.company.connection.ConnectionPool;
import com.company.entity.User;
import com.company.mysql.MySQLUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


/**
 * Page after authorization
 */

@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet {
    MySQLUserDao mySQLMySQLUserDao;



    public AdminPageServlet() {
        super();
        mySQLMySQLUserDao = new MySQLUserDao();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


       // List<User> userList = getUserList(); //getProductList();
        request.setAttribute("users", mySQLMySQLUserDao.findAll());
        // response.setContentType("text/html");
// Переходим на JSP страницу

        RequestDispatcher dispatcher = request.getRequestDispatcher("/page/admin/adminEnterPage.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);

        }
    }

}
