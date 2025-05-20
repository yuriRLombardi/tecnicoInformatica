<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultado</title>
	</head>
	<body>
		<h3>Resultado</h3>
		<%
			String maiores = (String)request.getAttribute("maiores");
		%>
		<p><%= maiores %></p>
	</body>
</html>