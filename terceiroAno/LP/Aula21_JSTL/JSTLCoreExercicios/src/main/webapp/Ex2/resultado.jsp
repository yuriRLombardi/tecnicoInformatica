<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultados</title>
	</head>
	<body>
		<h1>Resultado do teste de digitação</h1>
		<p>PPM ${resultado }</p>
		<c:choose>
				<c:when test="${resultado < 10}">
					<p>Velocidade muito baixa. Aprenda técnicas de digitação e pratique para melhorar sua velocidade!</p>
				</c:when>
				<c:when test="${10< resultado && resultado <=40}">
					<p>Velocidade baixa. Foque em melhorar sua técnica e continue praticando!</p>
				</c:when>
				<c:when test="${40< resultado && resultado<=50}">
					<p>Velocidade média. Você ainda pode melhorar!</p>
				</c:when>
				<c:when test="${50<resultado && resultado <=90}">
					<p>Velocidade alta. Parabéns!</p>
				</c:when>
				<c:otherwise>
					<p>Velocidade muito alta. Você está indo muito bem, parabéns!</p>
				</c:otherwise>
			</c:choose>
	</body>
</html>