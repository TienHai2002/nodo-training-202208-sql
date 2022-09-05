
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>ADD Group</h1>
		<form method="post" action="/nhom/luu">
			<p>
				<form:input type="text" path="name" name="name"/>
			</p>
			<p class="submit">
				<input type="submit" name="add" value="Add">
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>
</body>
</html>