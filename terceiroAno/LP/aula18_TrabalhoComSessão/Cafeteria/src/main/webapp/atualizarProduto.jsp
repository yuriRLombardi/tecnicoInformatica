<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%
		Produto produto = (Produto)request.getAttribute("produto");
		String[] ingrediente = produto.getIngredientes();
	%>
	<%!
		String checked(String value,String[] vetor){
			if(vetor != null){
				for(int i = 0;i < vetor.length;i++){
					if(vetor[i].equals(value)){
						return "checked";
					}
				}
			}
			return "";
		}
	%>
	<form action="CafeteriaController" method="post" class="formulario">
		<label for=id>ID</label>
		<input type="number" id = "id" name="id" value="<%=produto.getId() %>" readonly><br><br>
		
		<label for="nomeId">Nome:</label>
    	<input type="text" id="nomeId" name="nome" value="<%=produto.getNome() %>"><br><br> 
      
	    <label for="desc">Descrição:</label><br> 
	    <textarea id="desc" name="desc"><%=produto.getDescricao() %></textarea><br><br> 
      
	    <label for="preco">Preço:</label>
	    <input type="number" id="preco" step="0.01" min="0" name="preco" value="<%=produto.getPreco() %>"><br><br> 
      
	    <label for="dataId">Data de Validade:</label>
	    <input type="date" id="dataId" name="dataVal" value="<%=produto.getValidade() %>"><br><br> 
    	<fieldset>
	    	 <p>Ingredientes Alérgicos:</p> 
	    	<label><input type="checkbox" name="ingrediente" value="Amendoim" <%=checked("Amendoim",ingrediente) %>> Amendoim</label>
	    	<label><input type="checkbox" name="ingrediente" value="Gordura Saturada" <%=checked("Gordura Saturada",ingrediente) %>> Gordura Saturada</label>
	    	<label><input type="checkbox" name="ingrediente" value="Derivados de Leite" <%=checked("Derivados de Leite",ingrediente) %>> Derivados de Leite</label> 
	    	<label><input type="checkbox" name="ingrediente" value="Glúten" <%=checked("Glúten",ingrediente) %>> Glúten</label>
	    	<label><input type="checkbox" name="ingrediente" value="Áçucar" <%=checked("Áçucar",ingrediente) %>> Açúcar</label>
    	</fieldset>
	   
	    <label for="taxa">Taxa De Entrega (%):</label>
	    <input type="number" id="taxa" step="0.01" min="0" max="100" name="taxa" value="<%=produto.getTaxaEntrega() %>"><br><br> 
    
    	<button type="submit" value="Atualizar" name = "operacao">Atualizar</button>
	</form>
	<span class="formulario"><a href="indexProduto.html"><button>Cancelar</button></a></span>
	</main>
</body>
</html>