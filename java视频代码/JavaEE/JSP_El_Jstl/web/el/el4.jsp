<%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/28 0028
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
    ${pageContext.request}<br/>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}

</body>
</html>
