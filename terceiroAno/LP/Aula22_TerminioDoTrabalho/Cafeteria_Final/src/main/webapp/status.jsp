<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<c:choose>
			<c:when test="${status}">
				<p>Produto não ${operacao} com sucesso</p>
			</c:when>
			<c:otherwise>
				<p>Produto ${operacao} com sucesso</p>
			</c:otherwise>
		</c:choose>
		<button><a href="indexProduto.jsp">Voltar a página principal</a></button>
	</div>
</body>
</html>