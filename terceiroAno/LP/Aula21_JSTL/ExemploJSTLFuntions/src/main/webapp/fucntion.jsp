<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exemplo JSTL Functions</title>
	</head>
	<body>
		<c:set var="frase" value="Exemplos de usos do JSTL Functions"/>
		<p>Frase: ${frase}</p>
		<p>Tamanho da String: ${fn:length(frase)}</p>
		<p>Maiúscula: ${fn:toUpperCase(frase)}</p>
		<p>Minúscula: ${fn:toLowerCase(frase)}</p>
		<p>SubString: ${fn:substring(frase,9,23)}</p>
		<p>SubString após: ${fn:substringAfter(frase,"Exemplos")}</p>
		<p>Substring antes: ${fn:substringBefore(frase,"JSTL")}</p>
		<p>Substituição de caracteres: ${fn:replace(frase,"Functions","Core")}</p>
		<p>Índice de JSTL: ${fn:indexOf(frase,"JSTL")}</p>
	</body>
</html>