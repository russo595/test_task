<%@ tag pageEncoding="UTF-8"%>

<form action="/login/enter" method="post" class="form">
	
	<h4>Войдите</h4>
	
	<div class="line">
		<label for="login">Логин</label>
		<input name="login" type="text" value="${oldEnter.vals.login}">
	</div>
	
	<div class="line">
		<label for="psw">Пароль</label>
		<input name="psw" type="password" value="${oldEnter.vals.psw}">
	</div>
	
	<div class="error">${oldEnter.error}</div>
	
	<div class="end">
		<button>Вход</button>
	</div>

</form>