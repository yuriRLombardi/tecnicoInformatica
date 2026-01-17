<%@ page import="model.Tarefa" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Remoção da Tarefa</title>
	</head>
	<body>
		<h3>Remoção da Tarefa</h3>
		
		<%
			Tarefa tarefa = (Tarefa) request.getAttribute("tarefa");
		%>
		
		<ul>
			<li>ID: <%= tarefa.getId() %></li>
			<li>Descrição: <%= tarefa.getDescricao() %></li>
			<li>Prioridade: <%= tarefa.getPrioridade() %></li>
		</ul>
		
		<p>Tem certeza que deseja remover essa tarefa?</p>
		
		<form action="TarefaController" method="post">
			<input type="hidden" name="id" value=<%= tarefa.getId() %>>
		
			<input type="submit" value="Remover" name="operacao"><br><br>
		</form>
		<a href="index.html"><input type="button" value="Cancelar"></a>
	</body>
</html>