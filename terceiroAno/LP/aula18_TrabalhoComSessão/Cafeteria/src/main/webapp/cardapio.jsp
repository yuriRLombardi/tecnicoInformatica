<%@page import="java.text.DecimalFormat"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <a href="cafeteria.html">CAFETERIA</a>
      <a href="remocaoUsuario.html">LOGOUT</a>
    </nav>
  </header>

  <main class="pagina">
    <h1>Nosso Cardápio</h1>
    <section class="cardapio">
      <%
        DecimalFormat formato = new DecimalFormat("#,###.00");
        ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("produtos");
        String opercao = (String) request.getAttribute("operacao");
        int id = 0;
        if(request.getAttribute("id") != null){
          id = (int) request.getAttribute("id");
        }

        if(produtos != null){
          for(Produto produto : produtos){
      %>
        <article class="item">
          <div class="item-header">
            <h2><%= produto.getNome() %></h2>
            <div class="icons">
				  <a href="CafeteriaController?operacao=Buscar&simbolo=editar&id=<%= produto.getId() %>">
				    <i class="fas fa-edit"></i>
				  </a>
				  <a href="CafeteriaController?operacao=Buscar&simbolo=lixeira&id=<%= produto.getId() %>">
				    <i class="fas fa-trash-alt"></i>
				  </a>
			</div>
            	
          </div>
          <div class="ds">
	          <p class="descricao"><%= produto.getDescricao() %></p>
	          <span class="preco">R$ <%= formato.format(produto.getPreco()) %></span>
          </div>

          <div class="botoes">
            <a href="CafeteriaController?operacao=Ingredientes&id=<%= produto.getId() %>">
              <button>Ingredientes Alérgico</button>
            </a>
            <a href="CafeteriaController?operacao=Entrega&id=<%= produto.getId() %>">
              <button>Valor de Entrega</button>
            </a>
            <a href="CafeteriaController?operacao=Validade&id=<%= produto.getId() %>">
              <button>Validade</button>
            </a>
          </div>
          

          <% if (opercao != null && id == produto.getId()) { %>
            <div class="info-extra">
              <% if (opercao.equals("validade")) {
                  String validade = (String) request.getAttribute("validade"); %>
                  <p><%= validade %></p>
              <% } else if (opercao.equals("entrega")) {
                  double taxa = (double) request.getAttribute("entrega"); %>
                  <p>Valor de Entrega: R$ <%= formato.format(taxa) %></p>
              <% } else if (opercao.equals("ingredientes")) {
                  String ingredientes = (String) request.getAttribute("ingredientes"); %>
                  <p>Restrições para: <%= ingredientes %></p>
              <% } %>
            </div>
          <% } %>
        </article>
      <%
          }
        }
      %>
    </section>
  </main>
</body>
</html>
