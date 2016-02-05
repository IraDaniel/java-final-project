package com.company.servlet.user;

import com.company.connection.ConnectionPool;
import com.company.entity.Product;
import com.company.entity.User;
import com.company.mysql.MySQLProductDao;
import com.company.mysql.MySQLUserDao;
import org.apache.commons.codec.digest.DigestUtils;

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
 * Created by Ira on 02.02.2016.
 */
@WebServlet("/EnterPageServlet")
public class EnterPageServlet extends HttpServlet {

    private MySQLUserDao mySQLMySQLUserDao;
    private MySQLProductDao mySQLProductDao;

    public EnterPageServlet() {
        super();
        mySQLMySQLUserDao = new MySQLUserDao();
        mySQLProductDao = new MySQLProductDao();
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
        //CheckUser
        User user = mySQLMySQLUserDao.findByLoginPass(login, DigestUtils.md5Hex(password));

        if(user.getId()!=0){
            HttpSession httpSession = request.getSession(true); // create new session
            httpSession.setAttribute("user",user); // add user to session
            //httpSession.setAttribute("locale","ru"); // add location to session
            response.sendRedirect("UserProductList");
        }else{
            response.sendRedirect("enterPage.jsp");
        }

    }

}
