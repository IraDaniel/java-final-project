<%@ page import="com.company.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.mysql.MySQLProductDao" %>
<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.company.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 04.02.2016
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Online shop</title>

    <!-- Bootstrap core CSS -->
    <link href="../../bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->

    <link href="justified-nav.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%
    HttpSession httpSession = request.getSession(true);
    String loc = null;

    if (httpSession.getAttribute("locale") == null) {
        loc = "ru";
        httpSession.setAttribute("locale",loc);
    } else {
        loc = (String) httpSession.getAttribute("locale");
    }
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
%>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li class="active"><a href="../page/startPage.jsp"><%= utilProperty.getValue("util.product")%></a></li>
            <li><a href="../page/user/newUser.jsp?change=0"><%= utilProperty.getValue("util.register")%>
            </a></li>
            <li><a href="../page/user/enterPage.jsp"><%= utilProperty.getValue("util.signIn")%>
            </a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/LocaleServlet?loc=ru&url=/page/startPage.jsp">ru</a></li>
            <li><a href="/LocaleServlet?loc=en&url=/page/startPage.jsp">en</a></li>
            <li><a href="../page/admin/adminEnterPage.jsp"><%=utilProperty.getValue("util.admin")%></a></li>
        </ul>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-8">
            <h2>Список товаров</h2>

            <div class="panel panel-default">
                <table class="table">
                    <tr>
                        <td><%= utilProperty.getValue("util.name")%>
                        </td>
                        <td><%= utilProperty.getValue("util.price")%>
                        </td>
                    </tr>
                    <% MySQLProductDao mySQLProductDao = new MySQLProductDao();
                        List<Product> data = mySQLProductDao.findAll();
                        for (Product product : data) {
                    %>
                    <tr>
                        <td><%=product.getName()%>
                        </td>
                        <td><%=product.getPrice()%>
                        </td>

                    </tr>


                    <%}%>
                </table>

            </div>
        </div>
    </div>


</div>
<!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
