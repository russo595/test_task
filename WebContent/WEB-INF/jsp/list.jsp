<%@ page contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="book" tagdir="/WEB-INF/tags/address-book" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:base title="Список записей">

	<jsp:attribute name="body">
		
		<div>
		
			<c:choose>
			
				<c:when test="${recs != null && recs.size() > 0}">
					
					<%-- Табличный вывод записей --%>
					<book:recs-table recs="${recs}"/>
					
				</c:when>
				
				<c:otherwise>
					Нет записей
				</c:otherwise>
				
			</c:choose>
	
		</div>
		
		
		<c:choose>
			<c:when test="${user != null}">
				<%-- Форма добавления --%>
				<book:add-rec-form/>
			</c:when>
			<c:otherwise>
				Для добавления новых записей, <a href="/login">войдите</a>.
			</c:otherwise>
		</c:choose>

		
	</jsp:attribute>
</layout:base>
