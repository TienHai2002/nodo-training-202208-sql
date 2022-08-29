<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/29/2022
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<tiles:insertDefinition name="template" >
    <tiles:putAttribute name="body">
        <h1>Login to Application</h1>
        <c:if test ="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form method="post" action="/login">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p>
                <input type="text" name="j_username"
                       placeholder="Username">
            </p>
            <p>
                <input type="password" name="j_password"
                       placeholder="Password">
            </p>
            <p><input type="submit" name="commit" value="Login"></p>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>