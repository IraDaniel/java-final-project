package com.company.servlet.order;

import com.company.entity.Order;
import com.company.entity.User;
import com.company.mysql.MySQLOrderDao;
import com.company.mysql.MySQLUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ira on 03.02.2016.
 */

/**
 * This servlet performs order processing
 * If User push "buy"
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private MySQLOrderDao mySQLOrderDao;
    private MySQLUserDao mySQLUserDao;

    public OrderServlet() {
        super();
        mySQLOrderDao = new MySQLOrderDao();
        mySQLUserDao = new MySQLUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null){
            request.setCharacterEncoding("utf-8");
            RequestDispatcher dispatcher = request.getRequestDispatcher("enterPage.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
        //TODO: Check, if user == null ?
        User user = (User)session.getAttribute("user");
        Integer idProduct = Integer.parseInt(request.getParameterValues("id")[0]);

        Order order = new Order();
        order.initOrder(user.getId(),idProduct,1,false);
        int idOrder = mySQLOrderDao.save(order);

        request.setAttribute("idOrder", idOrder);
        session.setAttribute("idOrder", idOrder);
        System.out.println(session.getAttribute("idOrder"));

       // mySQLUserDao.updateInfo(user.getId(),1);

        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderPage.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }


    }
}
