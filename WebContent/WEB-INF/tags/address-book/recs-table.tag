<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="recs" type="java.util.Collection" required="true"%>

<table>
	<tr>
		<td>Имя</td>
		<td>Адрес</td>
	</tr>
	<c:forEach items="${recs}" var="rec">
		<tr>
			<td>${rec.owner}</td>
			<td>${rec.address}</td>
		</tr>
	</c:forEach>
</table>