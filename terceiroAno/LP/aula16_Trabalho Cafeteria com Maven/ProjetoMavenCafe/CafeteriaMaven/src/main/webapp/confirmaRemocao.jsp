<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remoção Produto</title>
</head>
<body>
	<%
		Produto produto = (Produto)request.getAttribute("produto");
		String ingredientes = "Nenhum";
		if(produto.getIngredientes() != null){
			ingredientes = String.join(",", produto.getIngredientes());
		}
	%>
	<h3>Remoção Produto</h3>
	<ul>
		<li>Nome: <%=produto.getNome()%></li>
		<li>Descrição: <%=produto.getDescricao() %></li>
		<li>Preço: <%=produto.getPreco() %></li>
		<li>Ingredientes Alérgicos: <%=ingredientes %></li>
		<li>Taxa de Entrega: <%=produto.getTaxaEntrega() %></li>
		<li>Validade: <%=produto.getValidade() %></li>
	</ul>
	<p>Tem certeza que deseja remover esse produto?</p>
		<form action="CafeteriaController" method="post">
			<input type="hidden" name="id" value = "<%= produto.getId()%>">
			<input type="submit" value="Remover" name="operacao">
		</form>
	<a href="index.html"><input type="button" value="Cancelar"></a>
</body>
</html>