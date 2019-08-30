<%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/28 0028
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>主体信息</h1>
    <%--<h1>hello</h1>--%>
    <%
        pageContext.setAttribute("msg","hello");
    %>
    <%=pageContext.getAttribute("msg")%>
</body>
</html>
