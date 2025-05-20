<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultado da Converção</title>
	</head>
	<body>
		<%
			float celcius = (float) request.getAttribute("celcius");
		%>
		<h3>Resultado da Converção</h3>
		<p>Temperatura: <%=celcius %> °C</p>
	</body>
</html>