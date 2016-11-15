<%@ tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="title" required="true"%>
<%@attribute name="body" fragment="true" required="true"%>

<!doctype html>
<html>
<head>
	
	<title>${title}</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	
	<link rel="stylesheet" type="text/css" href="/css/main.css">
	
</head>
<body>
	
	<div id="header">
	
		<h4>
			<a href="/">
				<img src='/i/house.gif' width="24">
				Адресная книга - v.6
			</a>
		</h4>
		
		<div id="user-block" style="${skipUserBlock? 'display: none;' : ''}">
			<c:choose>
				<c:when test="${user != null}">
					Добро пожаловать, <b>${user.name}</b>!
					<a href="/logout">Выйти</a>
				</c:when>
				<c:otherwise>
					Здравствуйте, Гость! <a href="/login">Войти</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<hr>
		
		<h1>${title}</h1>
	</div>
	
	<div id="body-wrapper">
		<jsp:invoke fragment="body"/>
	</div>
	
	
</body>
</html>