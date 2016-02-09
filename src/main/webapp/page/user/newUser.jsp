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
<jsp:include page="/page/common_header.jsp"></jsp:include>
<body>
<%
    String loc = (String) request.getSession(true).getAttribute("locale");
    PropertyManager utilProperty = new PropertyManager(new Locale(loc, loc.toUpperCase()), "util");
    int isChange = Integer.parseInt(request.getParameterValues("change")[0]);

%>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <h3 class="text-muted"><%= utilProperty.getValue("util.project")%>
        </h3>

        <ul class="nav navbar-nav navbar-left">
            <li><a href="/page/startPage.jsp"><%= utilProperty.getValue("util.product")%>
                <li class="active"><a
                        href="/page/user/newUser.jsp?change=<%=isChange%>"><%= utilProperty.getValue("util.register")%>
                </a></li>
                <li><a href="/page/user/enterPage.jsp"><%= utilProperty.getValue("util.signIn")%>
                </a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/LocaleServlet?loc=ru&url=/page/user/newUser.jsp?change=<%=isChange%>">ru</a></li>
            <li><a href="/LocaleServlet?loc=en&url=/page/user/newUser.jsp?change=<%=isChange%>">en</a></li>
        </ul>


    </div>
</div>
<div class="container">
    <p class="lead">
            <%  if(isChange == 1){ %>

    <div class="alert alert-danger"><%= utilProperty.getValue("util.change")%>
    </div>
    <% }%>


    <form action="/NewUserServlet" method="post" class="form-signin">
        <input type="hidden" name="command" value="naming"/>

        <div class="alert alert-info"><%= utilProperty.getValue("util.regForm")%>
        </div>
        <br/>
        <%=utilProperty.getValue("util.userFirstName")%>:<br/> <input type="text" name="name" class="form-control">
        <br/>
        <%=utilProperty.getValue("util.userLastName")%>:<br/> <input type="text" name="surname"
                                                                     class="form-control"><br/>
        <%=utilProperty.getValue("util.login")%>: <br/><input type="text" name="login" class="form-control"><br/>
        <%=utilProperty.getValue("util.password")%> <br/><input type="password" name="password"
                                                                class="form-control"><br/>
        <br/>
        <button type="submit" class="btn btn-default"><%= utilProperty.getValue("util.save")%>
        </button>
    </form>
    </p>

</div>

</div>
<!-- /.container -->

</body>


