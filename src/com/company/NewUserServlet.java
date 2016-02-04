package com.company;

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
 * Created by Ira on 29.01.2016.
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {


   // private static final long serialVersionUID = 1L;
    private MySQLUserDao mySQLMySQLUserDao;
    private MySQLProductDao mySQLProductDao;


    public NewUserServlet() {
        super();
        mySQLMySQLUserDao = new MySQLUserDao();
        mySQLProductDao = new MySQLProductDao();
    }


    private void addNewUser(User user) {
        mySQLMySQLUserDao.save(user);
    }

    private List<Product> getProductList() {
        return mySQLProductDao.findAll();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameterValues("name")[0];
        String surname = request.getParameterValues("surname")[0];
        String login = request.getParameterValues("login")[0];
        String password = request.getParameterValues("password")[0];
        String md5Pass = DigestUtils.md5Hex(password);

        User user = new User();
        user.initUser(name, surname, login, md5Pass, false);
        addNewUser(user);

        if (user.getId() != 0) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            request.setAttribute("user", user);
            List<Product> products = getProductList();
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("usebean.jsp");

            if (dispatcher != null) {
                dispatcher.forward(request, response);

            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("enterPage.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);

            }
        }

    }

}
