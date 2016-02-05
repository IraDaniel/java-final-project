package com.company.servlet.user;

import com.company.entity.Product;
import com.company.entity.User;
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
 * Created by Ira on 04.02.2016.
 */
@WebServlet("/UserProductList")
public class UserProductListServlet extends HttpServlet {

    private MySQLProductDao mySQLProductDao;

    public UserProductListServlet() {
        super();
         mySQLProductDao = new MySQLProductDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true); // create new session
        User user = (User) httpSession.getAttribute("user"); // add user to session
        String local = (String) httpSession.getAttribute("locale"); // add location to session
        request.setAttribute("user", user);
        request.setAttribute("locale", local);
        List<Product> products = mySQLProductDao.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("usebean.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }
}
