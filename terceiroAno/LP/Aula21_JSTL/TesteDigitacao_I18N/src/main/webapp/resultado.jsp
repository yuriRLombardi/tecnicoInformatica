<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultados</title>
	</head>
	<body>
		<h1><fmt:message key="tituloR"/></h1>
		<p>PPM ${resultado}</p>
		<c:choose>
				<c:when test="${resultado < 10}">
					<p><fmt:message key="res1"/></p>
				</c:when>
				<c:when test="${10< resultado && resultado <=40}">
					<p><fmt:message key="res2"/></p>
				</c:when>
				<c:when test="${40< resultado && resultado<=50}">
					<p><fmt:message key="res3"/></p>
				</c:when>
				<c:when test="${50<resultado && resultado <=90}">
					<p><fmt:message key="res4"/></p>
				</c:when>
				<c:otherwise>
					<p><fmt:message key="res5"/></p>
				</c:otherwise>
			</c:choose>
	</body>
</html>