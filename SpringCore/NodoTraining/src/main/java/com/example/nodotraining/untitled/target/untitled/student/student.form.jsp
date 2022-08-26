
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<html>
<head>
	<title>Unit3</title>
</head>
<body>
<h2>Add student</h2>
<form:form method="POST" action="save">
	<table>
		<tr>
			<td>Name: </td>
			<td><form:input path="name" type="text"/><form:errors path="name"/></td>
		</tr>
		<tr>
			<td>Age: </td>
			<td><form:input path="age" type="number"/><form:errors path="age"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Submit">
			</td>

		</tr>
	</table>
</form:form>
</body> 
</html>

