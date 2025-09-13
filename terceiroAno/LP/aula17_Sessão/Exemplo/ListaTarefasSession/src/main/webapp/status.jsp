<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Status</title>
	</head>
	<body>
		<h3>Status da operação</h3>
		
		<%
			boolean status = (boolean) request.getAttribute("status");
			String operacao = (String) request.getAttribute("operacao");
			String mensagem;
			if (status)
				mensagem = "A tarefa foi " + operacao + " com sucesso!";
			else
				mensagem = "Erro! A tarefa não foi " + operacao + ".";
		%>
		
		<p><%= mensagem %></p>
		
		<p><a href="indexTarefa.html">Início</a></p>
	</body>
</html>