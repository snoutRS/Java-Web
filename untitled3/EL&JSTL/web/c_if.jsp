<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/4/15
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set value="1" var="visitCount" property="visitCount"></c:set>
    <c:if test="${visitCount==1}">
        welcome
    </c:if>
</body>
</html>
