<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Zhangxiong
  Date: 2019/8/28 0028
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("user",user);

        List list  = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list",list);

        HashMap map = new HashMap();
        map.put("sname","清凰");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);
    %>

    <h3>获取对象中的值</h3>
    ${requestScope.user}<br/>
    <%--
        通过的是对象的属性来获取
            setter或getter方法,去掉set或get,再将剩余部分，首字母变为小写
            setName-->Name-->name
    --%>
    ${requestScope.user.name}<br/>
    ${user.age}<br/>
    ${user.birthday}<br/>
    ${user.birthday.year}<br/>
    ${user.birStr}<br/>

    <hr/>
    <h3>获取List的值</h3>
    ${list}<br/>
    ${list[0]}<br/>
    ${list[1]}<br/>
    ${list[10]}<br/><%--优化了 不会报错--%>
    ${list[2].name}<br/>

    <hr/>
    <h3>获取Map的值</h3>
    ${map.sname}<br/>
    ${map["gender"]}<br/>
    ${map.user.name}<br/>
</body>
</html>
