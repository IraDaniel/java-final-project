package com.company.servlet.user;

import com.company.entity.Order;
import com.company.entity.User;
import com.company.mysql.MySQLOrderDao;

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
 * Created by Ira on 09.02.2016.
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {

    MySQLOrderDao mySQLOrderDao;

    public HistoryServlet() {
        super();
        mySQLOrderDao = new MySQLOrderDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        if( httpSession == null){
            request.setCharacterEncoding("utf-8");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/page/user/enterPage.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
        User user = (User)httpSession.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/page/startPage.jsp");
            return;
        }

        List<Order> history = mySQLOrderDao.findOrderByIdUserPaid(user.getId(), 1);
        request.setAttribute("history",history);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/page/user/historyPage.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }



    }
}
