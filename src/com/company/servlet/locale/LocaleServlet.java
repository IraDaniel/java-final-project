package com.company.servlet.locale;

import com.company.entity.Product;
import com.company.mysql.MySQLProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ira on 04.02.2016.
 */
@WebServlet("/LocaleServlet")
public class LocaleServlet extends HttpServlet {

    public LocaleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession(false);

        // String loc = httpSession.getAttribute
        String loc = request.getParameterValues("loc")[0];
        String url = request.getParameterValues("url")[0];
        httpSession.setAttribute("locale",loc);
        response.sendRedirect(url);




    }
}
