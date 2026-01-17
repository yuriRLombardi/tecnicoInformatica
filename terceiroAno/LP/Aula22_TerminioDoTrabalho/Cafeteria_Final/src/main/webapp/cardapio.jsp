<%@page import="java.text.DecimalFormat"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Cardápio | Café Virtual</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/cardapio.css">
</head>
<body>
  <header class="topo">
    <img src="img/Logo.png" alt="Logo Café" class="logo">
    <nav>
      <a href="indexProduto.jsp">INÍCIO</a>
      <a href="CafeteriaController?operacao=Listar" class="ativo">CARDÁPIO</a>
      <a href="cafeteria.jsp">CAFETERIA</a>
      <a href="remocaoUsuario.html">LOGOUT</a>
    </nav>
  </header>

  <main class="pagina">
    <h1>Nosso Cardápio</h1>
    <section class="cardapio">
	      <c:set var="operacao" value="${operacao}"/>
	      <c:if test="${id != null}">
	      	<c:set var="chave" value="${id}"/>
	      </c:if>
	      <c:if test="${produtos != null}">
		      	<c:forEach var="produto" items="${produtos}">
			      	<article class="item">
				          <div class="item-header">
				            <h2>${produto.getNome()}</h2>
					            <div class="icons">
									  <a href="CafeteriaController?operacao=Buscar&simbolo=editar&id=${produto.id}">
									    <i class="fas fa-edit"></i>
									  </a>
									  <a href="CafeteriaController?operacao=Buscar&simbolo=lixeira&id=${produto.id}">
									    <i class="fas fa-trash-alt"></i>
									  </a>
								</div> 	
				          </div>
				          <div class="ds">
					          <p class="descricao">${produto.descricao}</p>
					          <span class="preco"><fmt:formatNumber value="${produto.preco}" type="currency" /></span>
				          </div>
				
				          <div class="botoes">
					            <a href="CafeteriaController?operacao=Ingredientes&id=${produto.id}">
					              <button>Ingredientes Alérgico</button>
					            </a>
					            <a href="CafeteriaController?operacao=Entrega&id=${produto.id}">
					              <button>Valor de Entrega</button>
					            </a>
					            <a href="CafeteriaController?operacao=Validade&id=${produto.id}">
					              <button>Validade</button>
					            </a>
				            </div>
				            <c:if test="${operacao != null && chave == produto.id}">
				            	<div class="info-extra">
				            		<c:choose>
				            			<c:when test='${operacao == "validade"}'>
					                  		<p>${validade}</p>
				            			</c:when>
				            			<c:when test='${operacao == "entrega"}'>
					                  		<p>Valor de Entrega: <fmt:formatNumber value="${entrega}" type="currency" />  </p>
				            			</c:when>
				            			<c:when test='${operacao == "ingredientes"}'>
					                  		<p>Restrições para: ${ingredientes}</p>
				            			</c:when>
				            		</c:choose>
					            </div>
				            </c:if>
				          </article>
		      	</c:forEach>
	      </c:if>
    </section>
  </main>
</body>
</html>
