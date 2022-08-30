<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Jazz Application</title>
</head>
<body>
	<h1>Welcome to Spring Jazz </h1>
	<p><a href="/">Trang Chủ</a>
	<sec:authorize access="!hasAnyRole('ROLE_USER')">
		<a href="/login" style="margin-left: 30px">Dang nhap thi an vao day</a>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_USER')">
		<a href="/nguoi-dung" style="margin-left: 30px">Nguoi dung ne</a>
		<a href="/logout" style="margin-left: 30px">Logout</a>
		<a href="javascript:document.getElementById('logout').submit()">Dang xuat khoi trai dat</a>
	</sec:authorize>
	</p>
	<form action="/j_spring_security_logout" id="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	<tiles:insertAttribute name="body" />

</body>
</html>