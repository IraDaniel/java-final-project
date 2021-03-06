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
 * Created by Ira on 10.02.2016.
 */
@WebServlet("/SaveOrder")
public class SaveOrder extends HttpServlet {
    private MySQLOrderDao mySQLOrderDao;
    private MySQLUserDao mySQLUserDao;

    public SaveOrder() {
        super();
        mySQLOrderDao = new MySQLOrderDao();
        mySQLUserDao = new MySQLUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null){
            request.setCharacterEncoding("utf-8");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/page/user/enterPage.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }

        User user = (User)session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/page/startPage.jsp");
            return;
        }
        Integer number = Integer.parseInt(request.getParameterValues("number")[0]);
        //System.out.println(number);
        Integer idProduct = Integer.parseInt(request.getParameterValues("id")[0]);

        Order order = new Order();
        order.initOrder(user.getId(),idProduct,number,false);
        int idOrder = mySQLOrderDao.save(order);

        response.sendRedirect("/OrderServlet?id=" + idOrder);



    }
}
