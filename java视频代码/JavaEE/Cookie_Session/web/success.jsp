<%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/27 0027
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user") %>,欢迎您</h1>
</body>
</html>
