<%@ page import="java.util.ArrayList, model.Tarefa" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tarefas</title>
	</head>
	<body>
		<h3>Lista de Tarefas</h3>
		
		<%
			ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) request.getAttribute("tarefasBanco");
		%>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Descrição</th>
				<th>Prioridade</th>
			</tr>
			<%
				for (Tarefa tarefa : listaTarefas) {
					out.println("<tr>");
					out.println("<td>" + tarefa.getId() + "</td>");
					out.println("<td>" + tarefa.getDescricao() + "</td>");
					out.println("<td>" + tarefa.getPrioridade() + "</td>");
					out.println("<td><a href=\"TarefaController?operacao=Buscar&simbolo=lixeira&id=" + tarefa.getId() + "\"><img src=\"lixeira.png\" height=\"20px\"></a></td>");
					out.println("<td><a href=\"TarefaController?operacao=Buscar&simbolo=editar&id=" + tarefa.getId() + "\"><img src=\"editar.png\" height=\"20px\"></a></td>");
					out.println("</tr>");
				}
			%>
		</table>
		
		<p><a href="indexTarefa.html">Início</a></p>
	</body>
</html>