package com.company.servlet.admin;

import com.company.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Ira on 08.02.2016.
 */
@WebServlet("/AdminEnterPageServlet")
public class AdminEnterPageServlet extends HttpServlet {
    public AdminEnterPageServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        // getParam
        String login = request.getParameterValues("login")[0];
        String password = request.getParameterValues("password")[0];

        ResourceBundle bundle = ResourceBundle.getBundle("admin");

        String pLogin = bundle.getString("admin.login");
        String pPassword = bundle.getString("admin.password");

        if(pLogin.equals(login) && pPassword.equals(password)){
            response.sendRedirect("/OrderListServlet");
        }else{
            response.sendRedirect("/page/startPage.jsp");
        }

        //Check login + password

     //   System.out.println(login + ":" + password);



    }
}
