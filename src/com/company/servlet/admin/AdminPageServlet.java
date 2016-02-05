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
 *
 */

@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet {

    String page = "adminPage.jsp";

    private List<User> getUserList(){

        MySQLUserDao mySQLMySQLUserDao = new MySQLUserDao();

        return mySQLMySQLUserDao.findAll();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
        // PrintWriter out = response.getWriter();
    /*    List<User> userList = getUserList(); //getProductList();
        request.setAttribute("users", userList);
        // response.setContentType("text/html");
// Переходим на JSP страницу

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        if (dispatcher != null) {
            dispatcher.forward(request, response);

        }*/
     /*   out.println("<html><head>");

        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");

        out.println("<title>Title</title>");
        out.println("</head><body>");*/

        //  System.out.println("!!!!!!!!!!!!!!" + products.get(1).toString());

        // out.println("<h1> Hello, world!!! </h1>");
        //  out.println(products.get(1).getName());
        //   out.println("</body></html>");





    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<User> userList = getUserList(); //getProductList();
        request.setAttribute("users", userList);
        // response.setContentType("text/html");
// Переходим на JSP страницу

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        if (dispatcher != null) {
            dispatcher.forward(request, response);

        }
    }

}
