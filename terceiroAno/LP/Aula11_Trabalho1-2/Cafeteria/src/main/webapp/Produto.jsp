<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="produtos.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Resultado do Produto</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
  <div class="logo">CAFETERIA</div>
  <nav>
    <a href="index.jsp">Cadastro</a>
  </nav>
</header>

<main class="main">
  <div>
    <%
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String nome = request.getParameter("nome");
      String desc = request.getParameter("desc");
      double preco = Double.parseDouble(request.getParameter("preco"));
      LocalDate validade = LocalDate.parse(request.getParameter("dataVal"));
      String[] ingre = request.getParameterValues("ingrediente");
      double taxa = Double.parseDouble(request.getParameter("taxa"));
      Produto p = new Produto(nome, desc, preco, ingre, taxa, validade);
    %>

    <h1>Informações do Produto</h1>
    <p><strong>Nome:</strong> <%= nome %></p>
    <p><strong>Descrição:</strong> <%= desc %></p>
    <p><strong>Preço:</strong> R$ <%= preco %></p>
    <p><strong>Validade:</strong> <%= validade.format(formato) %></p>

    <h3>Ingredientes Alérgicos:</h3>
    <ul>
      <%
        for(String i : ingre) {
          if (!i.equals("Nada")) {
            out.println("<li>" + i + "</li>");
          }
        }
      %>
    </ul>

    <p><strong>Taxa de Entrega:</strong> <%= taxa %>%</p>
    <h3>Não recomendado para:</h3>
    <ul>
      <%
        String[] rotulos = p.rotularProduto();
        for (String r : rotulos) {
          if (!r.equals("Nenhum Problema")) {
            out.println("<li>" + r + "</li>");
          }
        }
      %>
    </ul>

    <p><strong>Preço com taxa:</strong> R$ <%= p.calcularPreco() %></p>
    <p><strong>O produto está na validade?</strong> <%= p.verificarValidade() %></p>
  </div>
</main>

</body>
</html>
