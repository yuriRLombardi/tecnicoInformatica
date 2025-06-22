<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Situação</title>
</head>
<body>
	<h3>Situação</h3>
	<%
		boolean status = (boolean)request.getAttribute("situacao");
	%>
	<p><%=status?"Produto cadastrado com sucesso":"Produto não cadastrado com sucesso" %></p>
	<button><a href="index.html">Voltar a página principal</a></button>
</body>
</html>