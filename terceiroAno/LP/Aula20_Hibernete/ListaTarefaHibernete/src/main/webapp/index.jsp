<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h3>Aplicação Tarefas</h3>
		
		<form action="UsuarioController" method="post">
			<label for="loginId">Login: </label>
			<input type="text" id="loginId" name="login"><br><br>
			
			<label for="senhaId">Senha: </label>
			<input type="password" id="senhaId" name="senha"><br><br>
			
			<input type="submit" value="Entrar" name="operacao">
		</form>
		
		<%
			Boolean erro = (Boolean) request.getAttribute("erro");
			if (erro != null && erro)
				out.println("<p>Usuário e/ou senha incorretos!</p>");
		%>
		
		<p><a href="infoUsuario.html">Cadastre-se</a></p>
	</body>
</html>