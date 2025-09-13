<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Login - Cafeteria</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/login.css">
</head>
<body>
  <main class="pagina">
    <section class="login-box">
    
      <h1>Entrar na sua conta</h1>
      <form action="UsuarioController" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" required>

        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>

        <button type="submit" name="operacao" value="Entrar">Entrar</button>
    	
      </form>
      <a href="cadastrar.html"><button>Cadastro</button></a>
      <%
    	Boolean erro = (Boolean) request.getAttribute("erro");
        if(erro != null && erro)
        	out.print("<p class='erro'>Usuário ou senha incorretos!</p>");
    %>
    </section>
  </main>
	
</body>
</html>