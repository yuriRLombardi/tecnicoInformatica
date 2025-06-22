<%@page import="model.Tarefa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefas</title>
</head>
<body>
	<h3>Lista de Tarefas</h3>
	<%
		ArrayList<Tarefa> tarefasBanco = (ArrayList<Tarefa>) request.getAttribute("tarefasBanco");	
	%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Prioridade</th>
		</tr>
		<%
			
			for(Tarefa tarefas:tarefasBanco){
				out.print("<tr>");
				out.println("<td>"+tarefas.getId()+"</td>");
				out.println("<td>"+tarefas.getDescricao()+"</td>");
				out.println("<td>"+tarefas.getPrioridade()+"</td>");
				out.println("<td><a href = \"TarefaController?operacao=Buscar&simbolo=lixeira&id="+tarefas.getId()+"\"><img src=\"lixeira.png\" height= \"20px\"></a></td>");
				out.println("<td><a href = \"TarefaController?operacao=Buscar&simbolo=editar&id="+tarefas.getId()+"\"><img src=\"editar.png\" height= \"20px\"></a></td>");
				out.print("</tr>");
			}
		%>
	</table>
	<a href="index.html"><input type="button" value="Início"></a>
</body>
</html>