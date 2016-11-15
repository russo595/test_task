<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/add" method="post">

	<div id="addForm" class="form">
		
		<h4>Добавить</h4>
		
		<c:if test="${error != null}">
			<div class="error">${error}</div>
		</c:if>
	
		Имя <input name="owner" type="text" value="${oldOwner}">
		<p>
		Адрес <input name="address" type="text" value="${oldAddr}">
		<p>
		<input type="submit" value="Добавить">
	</div>
</form>