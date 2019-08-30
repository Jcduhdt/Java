<%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/28 0028
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page isELIgnored="true" %>--%><%--忽略当前jsp页面中所有表达式--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3>4}
    \${3>4}

    <hr/>
    <h3>算数运算符</h3>
    ${3 + 4}<br/>
    ${3 / 4}<br/>
    ${3 div 4}<br/>
    ${3 % 4}<br/>
    ${3 mod 4}<br/>
    <hr/>
    <h3>比较运算符</h3>
    ${3 == 4}<br/>

    <h3>逻辑运算符</h3>
    ${3>4 && 3<4}<br/>
    ${3>4 and 3<4}<br/>

    <h4>empty运算符</h4>
    <%
        String str = "abc";
        request.setAttribute("str",str);
    %>
    ${not empty str}<br/>
</body>
</html>
