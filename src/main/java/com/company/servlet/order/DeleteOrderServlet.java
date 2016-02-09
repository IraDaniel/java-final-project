package com.company.servlet.order;

import com.company.mysql.MySQLOrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ira on 09.02.2016.
 */
@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    MySQLOrderDao mySQLOrderDao;

    public DeleteOrderServlet() {
        super();
        mySQLOrderDao = new MySQLOrderDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //HttpSession httpSession = request.getSession(false);
        int idOrder = Integer.parseInt(request.getParameterValues("idOrder")[0]);
        mySQLOrderDao.delete(idOrder);
        response.sendRedirect("/UserProductList");


    }
}
