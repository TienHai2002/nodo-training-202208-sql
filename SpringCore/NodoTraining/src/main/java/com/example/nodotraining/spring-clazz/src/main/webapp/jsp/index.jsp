<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h2>${message}</h2>
    </tiles:putAttribute>
</tiles:insertDefinition>