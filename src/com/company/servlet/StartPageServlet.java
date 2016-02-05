package com.company.servlet;

import com.company.connection.ConnectionPool;
import com.company.entity.Product;
import com.company.connection.ConnectionPoolSingleton;
import com.company.mysql.MySQLProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Ira on 29.01.2016.
 */
@WebServlet("/StartPageServlet")
public class StartPageServlet extends HttpServlet {
    String page = "startPage.jsp";
    MySQLProductDao mySQLProductDao;

    public StartPageServlet() {
        super();
        mySQLProductDao = new MySQLProductDao();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> products = mySQLProductDao.findAll();
        request.setAttribute("products", products);


        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("locale","ru");

    }



}