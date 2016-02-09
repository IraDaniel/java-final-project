<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.company.entity.Order" %>
<%@ page import="com.company.mysql.MySQLProductDao" %>
<%@ page import="com.company.mysql.MySQLUserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/page/common_header.jsp"></jsp:include>
<body>


<%
    String loc = (String) request.getSession(true).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
    List<User> userList = (List) request.getAttribute("users");
    List<Double> debtList = (List) request.getAttribute("debts");

    // String name = (String) request.getAttribute("name");
%>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="/OrderListServlet"> <%= utilProperty.getValue("util.orders")%>
            </a></li>
            <li><a href="/ExitServlet"><%= utilProperty.getValue("util.exit")%>
            </a></li>
        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><a href="LocaleServlet?loc=ru&url=UserListServlet">ru</a></li>
            <li><a href="LocaleServlet?loc=en&url=UserListServlet">en</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <h2><%= utilProperty.getValue("util.project")%>
        </h2>

        <p class="lead">

        <table border="1" width="303" class="table">
            <tr>
                <td><b><%= utilProperty.getValue("util.name")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.debt")%>
                </b></td>
                <td><b><%= utilProperty.getValue("util.blacklist")%>
                </b></td>
            </tr>
            <%
                int i = 0;
                for (User user : userList) {
                    String isBlack;
                    if (user.isBlack()) {
                        isBlack = utilProperty.getValue("util.yes");
                    } else {
                        isBlack = utilProperty.getValue("util.no");
                    }
            %>
            <tr>
                <td><a href="/UserOrdersServlet?id=<%=user.getId()%>"><%=user.getNameSurname()%>
                </a>
                </td>
                <td><%=debtList.get(i)%>
                </td>
                <td><%=isBlack%>
                </td>
            </tr>


            <%
                    i++;
                }
            %>
        </table>
        </p>


    </div>


</div>
</div>
<!-- /.container -->
</body>
</html>
