<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/28 0028
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器异常...</h1>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
