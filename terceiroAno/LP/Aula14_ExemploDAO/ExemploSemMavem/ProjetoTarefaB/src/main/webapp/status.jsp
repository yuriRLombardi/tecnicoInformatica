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
		boolean status = (boolean)request.getAttribute("status");
	%>
	<p><%=status?"A tarefa foi cadastrada com sucesso.":"Erro! A tarefa não foi cadastrada." %></p>

</body>
</html>