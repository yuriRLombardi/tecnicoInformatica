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
			double area = (double) request.getAttribute("areaR");
			double perimetro = (double) request.getAttribute("perimetroR");
		%>
		<p>Área do retângulo: <%= area %></p>
		<p>Perímetro do retângulo: <%= perimetro %></p>
	</body>
</html>