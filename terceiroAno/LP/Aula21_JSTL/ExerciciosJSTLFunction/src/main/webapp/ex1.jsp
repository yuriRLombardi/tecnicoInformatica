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
		<c:set var="filmes" value="Confira os lançamentos de filmes de Natal"/>
		<p>Frase: ${filmes}</p>
		<p>Frase em maiúsculas: ${fn:toUpperCase(filmes)}</p>
	</body>
</html>
