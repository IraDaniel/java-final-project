<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.company.mysql.MySQLOrderDao" %>
<%@ page import="com.company.mysql.MySQLProductDao" %>
<%@ page import="com.company.entity.Order" %>
<%@ page import="com.company.entity.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 03.02.2016
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/page/common_header.jsp"></jsp:include>
<body>
<%

    String loc = (String) request.getSession(true).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
    Integer id = (Integer) session.getAttribute("idOrder");
    MySQLOrderDao mySQLOrderDao = new MySQLOrderDao();
    Order order = mySQLOrderDao.findById(id);
    MySQLProductDao productDao = new MySQLProductDao();
    Product product = productDao.findById(order.getIdProduct());
    double price = order.getNumber() * product.getPrice();


%>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="/UserProductList"><%= utilProperty.getValue("util.product")%>
            </a></li>
            <li><a href="/BasketServlet"><%= utilProperty.getValue("util.basket")%>
            </a></li>
            <li><a href="/ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>
        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><a href="/LocaleServlet?loc=ru&url=/page/user/orderPage.jsp">ru</a></li>
            <li><a href="/LocaleServlet?loc=en&url=/page/user/orderPage.jsp">en</a></li>
        </ul>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-8">
            <h2><%=utilProperty.getValue("util.prepareOrder")%>
            </h2>

            <p><%=product.getName()%>, <%=utilProperty.getValue("util.number")%> : <%=order.getNumber()%>
            </p><br>

            <p><%=utilProperty.getValue("util.price")%> : <%=price%> руб.</p>
            <br>

            <form action="/PaymentServlet" method="post" class="navbar-form navbar-left">
                <input type="hidden" name="idOrder" value="<%=id%>">
                <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.pay")%>
                </button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
