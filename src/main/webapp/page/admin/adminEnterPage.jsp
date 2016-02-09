<%@ page import="com.company.bundle.PropertyManager" %>
<%@ page import="java.util.Locale" %>
<%--
  Created by IntelliJ IDEA.
  User: Ira
  Date: 02.02.2016
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<jsp:include page="/page/common_header.jsp"></jsp:include>

<body>
<%
    HttpSession httpSession = request.getSession(true);
    String loc = null;
    if (httpSession.getAttribute("locale") == null) {
        loc = "ru";
        httpSession.setAttribute("locale", loc);
    } else {
        loc = (String) httpSession.getAttribute("locale");
    }
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
%>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="LocaleServlet?loc=ru&url=adminEnterPage.jsp">ru</a></li>
            <li><a href="LocaleServlet?loc=en&url=adminEnterPage.jsp">en</a></li>
        </ul>


    </div>
</div>
<div class="container">
    <form class="form-signin" role="form" action="/AdminEnterPageServlet" method="post">
        <h2 class="form-signin-heading"><%= utilProperty.getValue("util.enter")%>
        </h2>
        <input type="hidden" name="command" value="naming"/>
        <%= utilProperty.getValue("util.login")%><br/> <input type="text" name="login" class="form-control" required
                                                               autofocus> <br/>
        <%= utilProperty.getValue("util.password")%><br/><input type="password" name="password" class="form-control"
                                                                 required><br/>
        <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.login")%>
        </button>
    </form>

</div>

<!-- /.container -->


</body>
</html>
