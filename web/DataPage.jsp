<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 29.01.2016
  Time: 20:49
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
<table border="1" width="303" class="table">
  <tr>
    <td width="119"><b>Название товара</b></td>
    <td width="168"><b>Стоимость, руб</b></td>
  </tr>
  <%  List<Product> data2 = (List)request.getAttribute("products");
    for(Product product: data2){
  %>
  <tr>
    <td><%=product.getName()%></td>
    <td><%=product.getPrice()%></td>
  </tr>


  <%}%>
</table>
</body>
</html>
