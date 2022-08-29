<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><a href="/student/delete/${student.id}">Delete</a></td>
            <td><a href="/student/edit/${student.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>