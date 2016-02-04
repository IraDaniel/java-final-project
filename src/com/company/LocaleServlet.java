package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Ira on 04.02.2016.
 */
public class LocaleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession(false);
        String loc = "ru";
      //  PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()),"util");
        httpSession.setAttribute("locale",loc);
       // response.sendRedirect("enterPage.jsp");


    }
}
