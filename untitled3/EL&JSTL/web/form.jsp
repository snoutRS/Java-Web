<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/4/15
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/EL_JSTL/form.jsp">
    <c:if test="${empty param.name}">
        <input type="text" name="name">
        <input type="submit" value="submit">
    </c:if>
    <c:out value="${param.name}"></c:out>

</form>
</body>
</html>
