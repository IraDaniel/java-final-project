<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 29.01.2016
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Enter Page</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

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
    HttpSession httpSession = request.getSession(false);
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
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%></h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="#">Projects</a></li>
            <li><a href="newUser.jsp"><%= utilProperty.getValue("util.register")%></a></li>
            <li><a href="enterPage.jsp"><%= utilProperty.getValue("util.login")%></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="LocaleServlet?loc=ru&url=enterPage.jsp">ru</a></li>
            <li><a href="LocaleServlet?loc=en&url=enterPage.jsp">en</a></li>
        </ul>



    </div>
</div>
<div class="container">
    <form class="form-signin" role="form" action="EnterPageServlet" method="post">
        <h2 class="form-signin-heading"><%= utilProperty.getValue("util.enter")%></h2>
        <input type="hidden" name="command" value="naming"/>
        <%= utilProperty.getValue("util.iLogin")%><br/> <input type="text" name="login" class="form-control" required autofocus> <br/>
        <%= utilProperty.getValue("util.iPassword")%><br/><input type="password" name="password" class="form-control" required><br/>
        <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.login")%></button>
    </form>

</div>

<!-- /.container -->


</body>
</html>

