<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Situação</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/status.css">
</head>
<body>
	<div class = "centro">
			<h1>Situação:</h1>
		<%
			boolean status = (boolean)request.getAttribute("situacao");
			String operacao = (String)request.getAttribute("operacao");
		%>
		<p><%=status?"Produto "+operacao+" com sucesso":"Produto não "+operacao+" com sucesso" %></p>
		<button><a href="indexProduto.jsp">Voltar a página principal</a></button>
	</div>
</body>
</html>