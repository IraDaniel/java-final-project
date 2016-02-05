<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.company.entity.Order" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 04.02.2016
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.ico">

<title>Show DB</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet">

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

    String loc = (String) request.getSession(true).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");

%>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="UserProductList"><%= utilProperty.getValue("util.product")%>
            </a></li>
            <li><a href="ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>
        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><a href="LocaleServlet?loc=ru&url=orderPage.jsp">ru</a></li>
            <li><a href="LocaleServlet?loc=en&url=orderPage.jsp">en</a></li>
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
            </tr>
            <% List<Order> basket = (List) request.getAttribute("basket");
                ;
                for (Order order : basket) {
            %>
            <tr>
                <td><%=order.getIdProduct()%>
                </td>
                <td><%=order.getIdUser()%>
                </td>
            </tr>

            <%}%>
        </table>
    </div>
</div>
</body>
</html>
