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
		<c:set var="natalinos" value="Diversas produções natalinas estreiam no catálogo da Netflix durante o final do ano"/>
		<p>Frase: ${natalinos}</p>
		<p>Começa com a palavra "produções"? ${fn:startsWith(natalinos, "produções")}</p>
		<p>Termina com a palavra "ano"? ${fn:endsWith(natalinos, "ano")}</p>
		<p>Tem a palavra "Natal"? ${fn:contains(natalinos, "Natal")}</p>
	</body>
</html>