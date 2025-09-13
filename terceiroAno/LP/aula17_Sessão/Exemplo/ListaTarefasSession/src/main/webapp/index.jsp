<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Informações Usuário</h3>
		<form action="UsuarioController" method="post">
			<label for="loginId">Login: </label>
			<input type="text" id="loginId" name="login"><br><br>
			
			<label for="senhaId">Senha: </label>
			<input type="password" id="senhaId" name="senha"><br><br>
			
			<button type="submit" name="operacao" value="Entrar">Entrar</button>
		</form>
		<p><a href = "infoUsuario.html">Cadastre-se</a></p>
		
		<%
			Boolean erro = (Boolean) request.getAttribute("erro");
			if(erro != null && erro)
				out.println("<p>Usuário ou senha incorretos!</p>");
		%>
</body>
</html>