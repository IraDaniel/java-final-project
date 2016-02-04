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
    <link href="jumbotron-narrow.css" rel="stylesheet">

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
<div class="container">

    <div class="starter-template">
        <p class="lead">

        <form action="NewUserServlet" method="post">
            <input type="hidden" name="command" value="naming"/>
            Заполните форму регистрации<br/>
            Имя:<br/> <input type="text" name="name"> <br/>
            Фамилия:<br/> <input type="text" name="surname"><br/>
            Логин: <br/><input type="text" name="login"><br/>
            Пароль:<br/><input type="password" name="password"><br/>
            <br/>
            <button type="submit">Сохранить</button>
        </form>
        </p>

    </div>

</div>
<!-- /.container -->

</body>


