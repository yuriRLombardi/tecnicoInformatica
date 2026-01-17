<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remoção Produto</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cafeteria.css">
</head>
<body>
	<c:choose>
		<c:when test="${produto.ingredientes != null}">
			<c:set var="ingredientes" value="${fn:join(produto.ingredientes,',')}"/>
		</c:when>
		<c:otherwise>
			<c:set var="ingredientes" value="Nenhum"/>
		</c:otherwise>
	</c:choose>
	<main class="pagina formulario-produto">
	<h1>Remoção Produto</h1>
	<ul>
		<li>Nome: ${produto.nome}</li>
		<li>Descrição: ${produto.descricao}</li>
		<li>Preço: ${produto.preco}</li>
		<li>Ingredientes Alérgicos: ${ingredientes}</li>
		<li>Taxa de Entrega: ${produto.taxaEntrega}</li>
		<li>Validade: ${produto.validade}</li>
	</ul>
	<p>Tem certeza que deseja remover esse produto?</p>
		<form action="CafeteriaController" method="post" class = "formulario">
			<input type="hidden" name="id" value = "${produto.id}">
			<button type="submit" value="Remover" name="operacao">Remover</button>
		</form>
		<span class="formulario"><a href="indexProduto.jsp"><button>Cancelar</button></a></span>
	</main>
	
</body>
</html>