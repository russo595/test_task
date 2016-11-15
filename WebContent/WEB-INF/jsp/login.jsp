<%@ page contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="login" tagdir="/WEB-INF/tags/login" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:base title="Добро пожаловать!">

	<jsp:attribute name="body">
		
		<div class="block">
		
			<login:enter/>
			
		</div>
		<div class="block">
		
			<login:new/>
			
		</div>
		
		
		
		
		
	</jsp:attribute>
</layout:base>