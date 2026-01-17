<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exercicios JSTL Functions</title>
	</head>
	<body>
		<h1>Lista de Filmes Natalinos</h1>
		<c:set var="filmesNatal" value="Sintonia de Natal,Um Amor Feito de Neve,No Ritmo de Natal,Nosso Segredinho"/>
		<c:set var="listaFilmes" value="${fn:split(filmesNatal,',')}"/>
		<ul>
			<c:forEach var="filme" items="${listaFilmes}">
				<li>${filme}</li>
			</c:forEach>
		</ul>
	</body>
</html>