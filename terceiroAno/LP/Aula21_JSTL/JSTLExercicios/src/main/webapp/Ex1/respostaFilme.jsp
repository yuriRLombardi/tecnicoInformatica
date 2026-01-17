<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ tagliburi="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Filmes</title>
</head>
	<body>
		<h3>Filmes</h3>
		 <c:set var="filmeEscolhido" value="${param.filmes}"/>
		<p>O filme escolhido foi: ${filmeEscolhido}</p>
	</body>
</html>