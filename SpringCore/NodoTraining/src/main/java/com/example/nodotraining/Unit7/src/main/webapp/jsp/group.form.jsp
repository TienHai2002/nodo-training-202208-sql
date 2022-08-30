<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Add Group</h1>	
		<form method="post" action="/group/add">
			<p>
				<input type="text">
			</p>
			<p class="submit">
				<input type="submit"
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>