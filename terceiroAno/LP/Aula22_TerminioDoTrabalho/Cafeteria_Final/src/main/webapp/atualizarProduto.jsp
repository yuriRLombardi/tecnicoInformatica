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
<title>Atualização Produto</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/cafeteria.css">
</head>
<body>
	<main class="pagina formulario-produto">
	<h1>Atualização Produto</h1>
	
	<form action="CafeteriaController" method="post" class="formulario">
		<label for=id>ID</label>
		<input type="number" id = "id" name="id" value="${produto.id}" readonly><br><br>
		
		<label for="nomeId">Nome:</label>
    	<input type="text" id="nomeId" name="nome" value="${produto.nome}"><br><br> 
      
	    <label for="desc">Descrição:</label><br> 
	    <textarea id="desc" name="desc">${produto.descricao}</textarea><br><br> 
      
	    <label for="preco">Preço:</label>
	    <input type="number" id="preco" step="0.01" min="0" name="preco" value="${produto.preco}"><br><br> 
      
	    <label for="dataId">Data de Validade:</label>
	    <input type="date" id="dataId" name="dataVal" value="${produto.validade}"><br><br> 
    	<fieldset>
    	<c:forEach var="checked" items="${produto.ingredientes}">
    	<c:choose>
    		<c:when test="${checked == 'Amendoim' }">
    	  		<c:set var="amendoim" value="checked"/>
    	  	</c:when>
    	  	<c:when test="${checked == 'Gordura Saturada' }">
    	  		<c:set var="gordura" value="checked"/>
    	  	</c:when>
    	  	<c:when test="${checked == 'Derivados de Leite' }">
    	  		<c:set var="leite" value="checked"/>
    	  	</c:when>
    	  	<c:when test="${checked == 'Glúten' }">
    	  		<c:set var="gluten" value="checked"/>
    	  	</c:when>
    	  	<c:when test="${checked == 'Áçucar' }">
    	  		<c:set var="acucar" value="checked"/>
    	  	</c:when>
    	</c:choose>
    	</c:forEach>
	    	 <p>Ingredientes Alérgicos:</p> 
	    	<label><input type="checkbox" name="ingrediente" value="Amendoim" ${amendoim} > Amendoim</label>
	    	<label><input type="checkbox" name="ingrediente" value="Gordura Saturada" ${gordura}> Gordura Saturada</label>
	    	<label><input type="checkbox" name="ingrediente" value="Derivados de Leite" ${leite}> Derivados de Leite</label> 
	    	<label><input type="checkbox" name="ingrediente" value="Glúten" ${gluten}> Glúten</label>
	    	<label><input type="checkbox" name="ingrediente" value="Áçucar" ${acucar}> Açúcar</label>
    	</fieldset>
	   
	    <label for="taxa">Taxa De Entrega (%):</label>
	    <input type="number" id="taxa" step="0.01" min="0" max="100" name="taxa" value="${produto.taxaEntrega}"><br><br> 
    
    	<button type="submit" value="Atualizar" name = "operacao">Atualizar</button>
	</form>
	<span class="formulario"><a href="indexProduto.jsp"><button>Cancelar</button></a></span>
	</main>
</body>
</html>