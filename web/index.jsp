<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 24.01.2016
  Time: 17:41
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

  <title>Narrow Jumbotron Template for Bootstrap</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="jumbotron-narrow.css" rel="stylesheet">

  <!-- Just for debugging purposes. Don't actually copy this line! -->
  <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
  <body>

  <div class="container">
    <div class="header">
      <ul class="nav nav-pills pull-right">
        <li class="active"><a href="">Войти</a></li>
        <li><a href="userPage/newUser.jsp">Зарегистрироваться</a></li>
      </ul>
      <h3 class="text-muted">Project name</h3>
    </div>

    <form action="AdminPageServlet" method="post">

      <input type="submit" value="forward()" /><br/>

    </form>

    <div class="row marketing">
      <div class="col-lg-6">
        <h4>Список товаров</h4>
        <p></p>
      </div>

      <div class="col-lg-6">
        <h4>Цена</h4>
        <p></p>
      </div>
    </div>

    <div class="footer">
      <p>&copy; Company 2014</p>
    </div>

  </div> <!-- /container -->


  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
