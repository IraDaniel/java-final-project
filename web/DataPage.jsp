<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 29.01.2016
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1" width="303">
  <tr>
    <td width="119"><b>ID</b></td>
    <td width="168"><b>Сообщение</b></td>
  </tr>
  <%Iterator itr;%>
  <% List data= (List)request.getAttribute("data");
    for (itr=data.iterator(); itr.hasNext(); ) {
  %>
  <tr>
    <td width="119"><%=itr.next()%></td>
    <td width="168"><%=itr.next()%></td>
  </tr>
  <%}%>
</table>
</body>
</html>
