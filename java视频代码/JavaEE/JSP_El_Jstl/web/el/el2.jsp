<%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/28 0028
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
    <%
        //在域中存储数据
        request.setAttribute("name","张三");
        session.setAttribute("age","23");
        session.setAttribute("name","李四");
    %>

    <h3>el获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}
    ${sessionScope.haha}
    ${name}<%--表示依次从最小的域中查找是否有该键对应的值，直到找到为止。--%>
</body>
</html>
