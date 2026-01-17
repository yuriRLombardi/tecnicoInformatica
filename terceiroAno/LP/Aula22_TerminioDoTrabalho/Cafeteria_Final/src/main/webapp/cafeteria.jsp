<!DOCTYPE html>
<%@page import="jakarta.servlet.http.Cookie"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Cafeteria - Cadastro de Produto</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/cafeteria.css">
</head>
<body>
<header class="topo">
    <img src="img/Logo.png" alt="Logo Café" class="logo">
    <nav>
      <a href="indexProduto.jsp">INÍCIO</a>
      <a href="CafeteriaController?operacao=Listar">CARDÁPIO</a>
      <a href="cafeteria.jsp" class="ativo">CAFETERIA</a>
      <a href="remocaoUsuario.html">LOGOUT</a>
    </nav>
  </header>
    <main class="pagina formulario-produto">
  <h1>Ultimo Produto Cadastrado:</h1>
	  <%
		  String nome = "";
		  double preco = 0.0;
		  String validade = "";
		  Usuario usuario = (Usuario) session.getAttribute("usuario");
		  Cookie[] cookies = request.getCookies();
		  if (cookies != null) {
			  for (Cookie c : cookies) {
				  if ((usuario.getLogin()+"_nome").equals(c.getName())) {
					  nome = URLDecoder.decode(c.getValue(),"utf-8");
			  	  }
				  if ((usuario.getLogin()+"_preco").equals(c.getName())) {
					  preco = Double.parseDouble(c.getValue());
			  	  }
				  if ((usuario.getLogin()+"_validade").equals(c.getName())) {
					  validade = c.getValue();
			  	  }
		  	  }
		  }
	  %>
	  <c:set var="nome" value="<%=nome %>"/>
	  <c:set var="preco" value="<%=preco %>"/>
	  <c:set var="validade" value="<%=validade %>"/>
	  
	  <form action="CafeteriaController" method="post" class="formulario">
	    <label for="nomeId">Nome:</label>
	    <input type="text" id="nomeId" name="nome" value="${nome}" readonly> 
	       
	    <label for="preco">Preço:</label>
	    <input type="number" id="preco" step="0.01" min="0" name="preco" value="${preco }" readonly> 
	      
	    <label for="dataId">Data de Validade:</label>
	    <input type="date" id="dataId" name="dataVal" value="${validade }" readonly> 
	  </form>
	</main>
  
  <main class="pagina formulario-produto">
  <h1>Cadastrar Novo Produto</h1>
  <form action="CafeteriaController" method="post" class="formulario">
    <label for="nomeId">Nome:</label>
    <input type="text" id="nomeId" name="nome" required="required"> 
      
    <label for="desc">Descrição:</label> 
    <textarea id="desc" name="desc"></textarea> 
      
    <label for="preco">Preço:</label>
    <input type="number" id="preco" step="0.01" min="0" name="preco" required="required"> 
      
    <label for="dataId">Data de Validade:</label>
    <input type="date" id="dataId" name="dataVal" required="required">
     
    <fieldset>
	    <legend>Ingredientes alérgicos</legend> 
	    <input type="checkbox" name="ingrediente" value="Amendoim" id="amendoim">
	    <label id="amendoim">Amendoim</label> 
	    <label><input type="checkbox" name="ingrediente" value="Gordura Saturada"> Gordura Saturada </label>
	    <label><input type="checkbox" name="ingrediente" value="Derivados de Leite"> Derivados de Leite </label>
	    <label><input type="checkbox" name="ingrediente" value="Glúten"> Glúten </label>
	    <label><input type="checkbox" name="ingrediente" value="Áçucar"> Açúcar </label>
    </fieldset>
    
    <label for="taxa">Taxa De Entrega (%):</label>
    <input type="number" id="taxa" step="0.01" min="0" max="100" name="taxa" required="required"> 
    
    <button type="submit" name= "operacao" value = "Cadastrar">Enviar</button>
  </form>
  <span class="formulario"><a href="indexProduto.jsp"><button>Cancelar</button></a></span>
</main>

</body>
</html>