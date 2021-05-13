<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/4/22
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随机抽取一个同学</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Servlet" method="post">
    <input type="submit" name="pick" value="抽取a班同学">
</form>
<form action="${pageContext.request.contextPath}/Servlet2" method="post">
    <input type="submit" name="pick1" value="抽取b班同学">
</form>
    <%
        String name = (String) request.getAttribute("name");
        if (name!=null && !name.isEmpty()){
            out.print(name);
        }
    %>
</body>
</html>
