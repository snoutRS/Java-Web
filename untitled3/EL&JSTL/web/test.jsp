<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/4/15
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:out value="${param.username}" default="unknown"/><br/>
    <c:out value="${param.username}" >unknown</c:out>
    <c:out value="${param.username}" escapeXml="false">
        <meta http-equiv="refresh" content="0;url=https://baidu.com"/>
    </c:out>
</body>
</html>
