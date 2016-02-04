package com.company;

import com.company.connection.ConnectionPool;
import com.company.entity.Product;
import com.company.connection.ConnectionPoolSingleton;
import com.company.mysql.MySQLProductDao;

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
 * Created by Ira on 29.01.2016.
 */
@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
    String page = "DataPage.jsp";
    private static final long serialVersionUID = 1L;

    public ProductsServlet() {
        super();
    }

    private List<Product> getProductList(){

        MySQLProductDao mySQLProductDao = new MySQLProductDao();

        return mySQLProductDao.findAll();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // PrintWriter out = response.getWriter();
        List<Product> products = getProductList();
        request.setAttribute("products", products);
       // response.setContentType("text/html");
// Переходим на JSP страницу

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        if (dispatcher != null) {
            dispatcher.forward(request, response);

        }
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
      //  processRequest();

    }


    private void processRequest() {
        System.out.println("I am here!!!");

    }

}