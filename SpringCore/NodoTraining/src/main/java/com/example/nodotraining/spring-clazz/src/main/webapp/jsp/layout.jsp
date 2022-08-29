<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/29/2022
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td height="30">Welcome to java Spring</td>
    </tr>
    <tr>
        <td><tiles:insertAttribute name="body"/></td>
    </tr>
    <tr>
        <td>
            <a href="/">Trang chủ</a>
            <sec:authorize access="!hasAnyRole('ROLE_USER')">
                <a href="/dang-nhap" style="margin-left: 30px">Đăng nhập</a>
            </sec:authorize>
            <sec:authorize access="!hasAnyRole('ROLE_USER')">
                <a href="/nguoi-dung" style="margin-left: 30px">Cá nhân</a>
                <a href="/logout" style="margin-left: 30px">Logout</a>
            </sec:authorize>
        </td>
    </tr>
</table>
</body>
</html>
