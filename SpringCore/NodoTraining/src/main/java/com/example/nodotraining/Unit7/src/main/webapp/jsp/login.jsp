<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Trang Đăng Nhập</h1>
		<c:if test="${not empty error}">
			<p>Sai tên đăng nhập hoặc mật khẩu</p>
		</c:if>
		<form method="post" action="/j_spring_security_check">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<p>
				<input type="text"  name="username" id="username" placeholder="username">
			</p>
			<p>
				<input type="password" name="password" id="password" placeholder="password">
			</p>
			<p class="submit">
				<input type="submit" name="commit" value="Login">
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>