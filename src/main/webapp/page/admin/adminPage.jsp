<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 08.02.2016
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.company.entity.Order" %>
<%@ page import="com.company.mysql.MySQLProductDao" %>
<%@ page import="com.company.mysql.MySQLUserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/page/common_header.jsp"></jsp:include>
<body>
<%
    String loc = (String) request.getSession(true).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
%>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="/UserListServlet"> <%= utilProperty.getValue("util.customers")%>
            </a></li>
            <li><a href="/ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>

        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><a href="/LocaleServlet?loc=ru&url=/OrderListServlet">ru</a></li>
            <li><a href="/LocaleServlet?loc=en&url=/OrderListServlet">en</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="starter-template">

        <p class="lead">

        <table border="1" width="303" class="table">
            <tr>
                <td><b><%= utilProperty.getValue("util.username")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.name")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.number")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.price")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.isPaid")%></b></td>

            </tr>
            <% List<Order> orderList = (List) request.getAttribute("orders");
                MySQLProductDao mySQLProductDao = new MySQLProductDao();
                MySQLUserDao mySQLUserDao = new MySQLUserDao();
                for (Order order : orderList) {
                    Product product = mySQLProductDao.findById(order.getIdProduct());
                    User user = mySQLUserDao.findById(order.getIdUser());
                    double price = order.getNumber() * product.getPrice();
                    String isPaid;
                    if(order.isPaid()){
                        isPaid = utilProperty.getValue("util.yes");
                    }else{
                        isPaid = utilProperty.getValue("util.no");
                    }

            %>
            <tr>
                <td><a href="/UserOrdersServlet?id=<%=user.getId()%>"><%=user.getNameSurname()%>
                </a>
                </td>
                <td><%=product.getName()%>
                </td>
                <td><%=order.getNumber()%>
                </td>
                <td><%=price%>
                </td>
                <td><%=isPaid%>
                </td>

            </tr>


            <%}%>
        </table>
        </p>

    </div>


</div>
</div>
<!-- /.container -->
</body>
</html>
