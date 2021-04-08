<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/4/8
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="divhead">
    <table cellspacing="0" class="headtable">
        <tr>
            <td>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/client/images/logo.png" width="200" height="60" border="0" />
                </a>
            </td>
            <td style="text-align:right">
                <img src="${pageContext.request.contextPath}/client/images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />&nbsp;<a href="#">购物车</a>
                | <a href="#">帮助中心</a>
                | <a href="#">我的帐户</a>
                | <a href="register.jsp">新用户注册</a>

            </td>
        </tr>
    </table>
</div>
</body>
</html>
