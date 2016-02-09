<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 30.01.2016
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/page/common_header.jsp"></jsp:include>
</head>
<body>


<%
    String loc = (String) request.getSession(false).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
    User user = (User) request.getSession(false).getAttribute("user");
%>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li class="active"><a href="/UserProductList"><%= utilProperty.getValue("util.product")%>
            </a></li>
            <li><a href="/BasketServlet"><%= utilProperty.getValue("util.basket")%>
            </a></li>
            <li><a href="/HistoryServlet"><%= utilProperty.getValue("util.history")%>
            </a></li>
            <li><a href="/ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>
        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><%= user.getNameSurname()%>
            </li>
            <li><a href="/LocaleServlet?loc=ru&url=/UserProductList">ru</a></li>
            <li><a href="/LocaleServlet?loc=en&url=/UserProductList">en</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <h2><%= utilProperty.getValue("util.project")%>
        </h2>

        <p class="lead">

        <table border="1" width="303" class="table">
            <thead>

            <th width="35%"><b><%= utilProperty.getValue("util.name")%>
            </b></th>
            <th width="15%"><b><%= utilProperty.getValue("util.price")%>
            </b></th>
            <th width="35%"><b><%= utilProperty.getValue("util.number")%>
            </b></th>
            <th width="15%"><b></b></th>

            </thead>
            <tbody>
            <% List<Product> data2 = (List) request.getAttribute("products");
                for (Product product : data2) {
            %>
            <tr>
                <td><%=product.getName()%>
                </td>
                <td><%=product.getPrice()%>
                </td>
                <form action="/SaveOrder" method="post">
                    <td>
                        <input type="number" min="1" value="1" name="number">
                    </td>
                    <td>
                        <input type="hidden" name="id" value="<%=product.getId()%>">

                        <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.buy")%>
                        </button>
                    </td>
                </form>
            </tr>


            <%}%>
            </tbody>
        </table>
        </p>

    </div>


</div>
</div>
<!-- /.container -->
</body>
</html>