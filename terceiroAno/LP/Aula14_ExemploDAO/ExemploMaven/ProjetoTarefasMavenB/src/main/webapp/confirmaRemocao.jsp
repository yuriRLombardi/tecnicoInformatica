<%@page import="model.Tarefa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>Remoção da Tarefas</title>
</head>
	<body>
		<h3>Remoção da Tarefas</h3>
		<%
			Tarefa tarefas= (Tarefa) request.getAttribute("tarefa");
		%>
		<ul>
			<li>ID: <%= tarefas.getId() %></li>
			<li>Descrição: <%= tarefas.getDescricao() %></li>
			<li>Prioridade: <%= tarefas.getPrioridade() %></li>
		</ul>
		<p>Tem certeza que deseja remover essa tarefa?</p>
		<form action="TarefaController" method="post">
			<input type="hidden" name="id" value = "<%= tarefas.getId()%>">
			<input type="submit" value="Remover" name="operacao">
		</form>
		<a href="index.html"><input type="button" value="Cancelar"></a>
	</body>
</html>