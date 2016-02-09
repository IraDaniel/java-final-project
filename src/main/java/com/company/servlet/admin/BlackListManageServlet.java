package com.company.servlet.admin;

import com.company.mysql.MySQLUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ira on 08.02.2016.
 */

/**
 * Add or delete user from "Black list" by ID User
 */
@WebServlet("/BlackListManageServlet")
public class BlackListManageServlet extends HttpServlet {
    MySQLUserDao mySQLUserDao;

    public BlackListManageServlet() {
        super();
        mySQLUserDao = new MySQLUserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameterValues("id")[0]);
        int key = Integer.parseInt(request.getParameterValues("key")[0]);
        mySQLUserDao.updateInfo(id, key);
        response.sendRedirect("UserListServlet");

    }
}
