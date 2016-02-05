<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 03.02.2016
  Time: 17:11
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
    Integer id = (Integer) session.getAttribute("idOrder");

  //  String id = (String)session.getAttribute("idOrder");
    System.out.println(session.getAttribute("idOrder"));

  //  int idOrder = Integer.parseInt(id);
    ;
%>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="UserProductList"><%= utilProperty.getValue("util.product")%>
            </a></li>
            <li><a href="BasketServlet"><%= utilProperty.getValue("util.basket")%>
            </a></li>
            <li><a href="ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>
            <li>
                <form action="ExitServlet" method="post" class="navbar-form navbar-right">
                    <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.exit")%>
                    </button>
                </form>
            </li>
        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><a href="LocaleServlet?loc=ru&url=orderPage.jsp">ru</a></li>
            <li><a href="LocaleServlet?loc=en&url=orderPage.jsp">en</a></li>
        </ul>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-8">
            <h2>Оформление заказа</h2>
            <form action="PaymentServlet" method="post" class="navbar-form navbar-left">
                <input type="hidden" name= "idOrder" value="<%=id%>">
                <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.pay")%>
                </button>
            </form>
        </div>
    </div>
</div>
<p> Оформить заказ</p>



</body>
</html>
