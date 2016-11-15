<%@ tag pageEncoding="UTF-8"%>

<form action="/login/new" method="post" class="form">
	
	<h4>Зарегистрируйтесь</h4>
	
	<div class="line">
		<label for="login">Логин</label>
		<input name="login" type="text" value="${oldNew.vals.login}">
	</div>
	
	<div class="line">
		<label for="psw">Пароль</label>
		<input name="psw" type="password" value="${oldNew.vals.psw}">
	</div>
	
	<div class="line">
		<label for="name">Имя</label>
		<input name="name" type="text" value="${oldNew.vals.name}">
	</div>
	
	<div class="error">${oldNew.error}</div>
	
	<div class="end">
		<button>Регистрация</button>
	</div>

</form>