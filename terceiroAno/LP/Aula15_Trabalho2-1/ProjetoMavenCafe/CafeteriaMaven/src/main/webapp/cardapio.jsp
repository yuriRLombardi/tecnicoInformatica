<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Cafeteria - Cardápio</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
  <div class="logo">CAFETERIA</div>
</header>
<body>
	<table border="1">
	<tr>
		<th>Nome</th>
		<th>Decrição</th>
		<th>Preço</th>
		<th>Ingredientes Alérgicos</th>
		<th>Taxa de Entrega</th>
		<th>Validade</th>
	</tr>
	<%
		ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("produtos");
		String ingredientes = "Nenhum";
		for(Produto produto: produtos){
			if(produto.getIngredientes() != null){
				ingredientes = String.join(",", produto.getIngredientes());
			}
			out.print("<tr>");
			out.print("<td>"+produto.getNome()+"</td>");
			out.print("<td>"+produto.getDescricao()+"</td>");
			out.print("<td>"+produto.getPreco()+"</td>");
			out.print("<td>"+ingredientes+"</td>");
			out.print("<td>"+produto.getTaxaEntrega()+"</td>");
			out.print("<td>"+produto.getValidade()+"</td>");
			out.print("</tr>");
		}
	%>
	</table>
	<br>
	<button><a href="index.html">Voltar a página principal</a></button>
</body>
</html>