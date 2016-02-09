<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.company.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.mysql.MySQLProductDao" %>
<%@ page import="com.company.entity.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 04.02.2016
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/page/common_header.jsp"></jsp:include>
<body>
<%

    String loc = (String) request.getSession(true).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
    MySQLProductDao mySQLProductDao = new MySQLProductDao();

%>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="/UserProductList"><%= utilProperty.getValue("util.product")%>
            </a></li>
            <li><a href="/ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/LocaleServlet?loc=ru&url=/BasketServlet">ru</a></li>
            <li><a href="/LocaleServlet?loc=en&url=/BasketServlet">en</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <table border="1" width="303" class="table">
            <tr>
                <td><b><%= utilProperty.getValue("util.name")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.price")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.number")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.pay")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.delete")%>
                </b></td>
            </tr>
            <% List<Order> basket = (List) request.getAttribute("basket");
                for (Order order : basket) {
                    Product product = mySQLProductDao.findById(order.getIdProduct());
                    double price = order.getNumber() * product.getPrice();
            %>
            <tr>
                <td><%= product.getName()%>
                </td>
                <td><%= price%>
                </td>
                <td><%= order.getNumber()%>
                </td>
                <td><a href="/PaymentServlet?idOrder=<%=order.getId()%>"><%= utilProperty.getValue("util.pay")%>
                </a>
                </td>
                <td><a href="/DeleteOrderServlet?idOrder=<%=order.getId()%>"><%= utilProperty.getValue("util.delete")%>
                </a>
                </td>
            </tr>

            <%}%>
        </table>
    </div>
</div>
</body>
</html>
