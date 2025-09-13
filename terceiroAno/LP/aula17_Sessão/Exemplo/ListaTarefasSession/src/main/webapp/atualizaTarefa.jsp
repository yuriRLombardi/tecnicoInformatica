<%@ page import="model.Tarefa" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Atualiza��o da Tarefa</title>
	</head>
	<body>
		<h3>Atualiza��o da Tarefa</h3>
		
		<%
			Tarefa tarefa = (Tarefa) request.getAttribute("tarefa");
		%>
		
		<form action="TarefaController" method="post">
			<label for="id">ID: </label>
			<input type="number" id="id" name="id" value="<%= tarefa.getId() %>" readonly><br><br>
		
			<label for="descricaoId">Descri��o: </label>
			<input type="text" id="descricaoId" name="descricao" value="<%= tarefa.getDescricao() %>"><br><br>
			
			<label for="prioridadeId">Prioridade: </label>
			<input type="range" id="prioridadeId" name="prioridade" min="1" max="5" value="<%= tarefa.getPrioridade() %>"><br><br>
			
			<input type="submit" value="Atualizar" name="operacao">
		</form>
	</body>
</html>