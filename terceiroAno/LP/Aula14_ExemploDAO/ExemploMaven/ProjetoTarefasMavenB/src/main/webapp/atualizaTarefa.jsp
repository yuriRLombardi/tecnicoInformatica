<%@page import="model.Tarefa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualização Tarefa</title>
</head>
<body>
	<h3>Atualização Tarefa</h3>
	<%
		Tarefa tarefa = (Tarefa) request.getAttribute("tarefa");
	%>
	<form action="TarefaController" method="post">
			<label for="id">ID</label>
			<input type="number" id="id" name="id" value="<%=tarefa.getId() %>" readonly><br><br>
	
			<label for="descricaoId">Descrição</label>
			<input type="text" id="descricaoID" name="descricao" value="<%=tarefa.getDescricao() %>"><br><br>
			
			<label for="prioridadeId">Prioridade</label>
			<input type="range" id="prioridadeID" name="prioridade" value="<%=tarefa.getPrioridade() %>" min="1" max="5"><br><br>
			
			<input type="submit" value="Atualizar" name="operacao">
			<a href="index.html"><input type="button" value="Voltar"></a>
	</form>
</body>
</html>