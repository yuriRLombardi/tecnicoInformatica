<%@page import="model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualização Produto</title>
</head>
<body>
	<h3>Atualização Produto</h3>
	<%
		Produto produto = (Produto)request.getAttribute("produto");
		String[] ingrediente = produto.getIngredientes();
	%>
	<%!
		String checked(String value,String[] vetor){
			for(int i = 0;i < vetor.length;i++){
				if(vetor[i].equals(value)){
					return "checked";
				}
			}
			return "";
		}
	%>
	<form action="CafeteriaController">
		<label for=id>ID</label>
		<input type="number" id = "id" name="id" value="<%=produto.getId() %>>" readonly="readonly"><br><br>
		
		<label for="nomeId">Nome:</label>
    	<input type="text" id="nomeId" name="nome" value="<%=produto.getNome() %>>"><br><br> 
      
	    <label for="desc">Descrição:</label><br> 
	    <textarea id="desc" name="desc" readonly="readonly"><%=produto.getDescricao() %></textarea><br><br> 
      
	    <label for="preco">Preço:</label>
	    <input type="number" id="preco" step="0.01" min="0" name="preco" value="<%=produto.getPreco() %>>"><br><br> 
      
	    <label for="dataId">Data de Validade:</label>
	    <input type="date" id="dataId" name="dataVal" value="<%=produto.getValidade() %>>"><br><br> 
    
	    <p>Ingredientes Alérgicos:</p> 
    	<input type="checkbox" name="ingrediente" value="Amendoim" <%=checked("Amendoim",ingrediente) %>> Amendoim<br> 
    	<input type="checkbox" name="ingrediente" value="Gordura Saturada" <%=checked("Gordura Saturada",ingrediente) %>> Gordura Saturada<br> 
    	<input type="checkbox" name="ingrediente" value="Derivados de Leite" <%=checked("Derivados de Leite",ingrediente) %>> Derivados de Leite<br> 
    	<input type="checkbox" name="ingrediente" value="Glúten" <%=checked("Glúten",ingrediente) %>> Glúten<br> 
    	<input type="checkbox" name="ingrediente" value="Áçucar" <%=checked("Açucar",ingrediente) %>> Açúcar<br><br> 
    	
	    <label for="taxa">Taxa De Entrega (%):</label>
	    <input type="number" id="taxa" step="0.01" min="0" max="100" name="taxa"><br><br> 
    
    	<input type="submit" value="Atualizar" name = "operacao">
    	<button><a href="index.html">Voltar a página principal</a></button>
	</form>
</body>
</html>