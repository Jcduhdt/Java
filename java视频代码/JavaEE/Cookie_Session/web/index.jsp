<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/26 0026
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Java Servlet Pages</title>
  </head>
  <body>

  <%
    System.out.println("hello jsp");
    int i = 5;
    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>

  <%!
    int i = 3;
  %>

  <%= "hello" %>
  <h1>hi·jsp</h1>
  <% response.getWriter().write("response"); %>

  </body>
</html>
