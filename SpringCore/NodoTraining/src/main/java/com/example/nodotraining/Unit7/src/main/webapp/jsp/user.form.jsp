<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Add User</h1>
		<form:form method="post" action="/tai-khoan/luu">
			<p>
				Tài Khoản: <form:input type="text" 
			<p class="submit">
				<input type="submit" name="add" value="Add">
			</p>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>