<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remoção Produto</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cafeteria.css">
</head>
<body>

	<%
		Produto produto = (Produto)request.getAttribute("produto");
		String ingredientes = "Nenhum";
		if(produto.getIngredientes() != null){
			ingredientes = String.join(",", produto.getIngredientes());
		}
	%>
	<main class="pagina formulario-produto">
	<h1>Remoção Produto</h1>
	<ul>
		<li>Nome: <%=produto.getNome()%></li>
		<li>Descrição: <%=produto.getDescricao() %></li>
		<li>Preço: <%=produto.getPreco() %></li>
		<li>Ingredientes Alérgicos: <%=ingredientes %></li>
		<li>Taxa de Entrega: <%=produto.getTaxaEntrega() %></li>
		<li>Validade: <%=produto.getValidade() %></li>
	</ul>
	<p>Tem certeza que deseja remover esse produto?</p>
		<form action="CafeteriaController" method="post" class = "formulario">
			<input type="hidden" name="id" value = "<%= produto.getId()%>">
			<button type="submit" value="Remover" name="operacao">Remover</button>
		</form>
		<span class="formulario"><a href="indexProduto.html"><button>Cancelar</button></a></span>
	</main>
	
</body>
</html>