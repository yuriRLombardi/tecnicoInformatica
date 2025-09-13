<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Daily Grind - Etapa Diária</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <header class="topo">
    <img src="img/Logo.png" alt="Logo Café" class="logo">
    <%
     	Usuario usuario = (Usuario) session.getAttribute("usuario");
    	out.print("<p class = 'esquerda'>Olá, "+usuario.getNome()+"</p>");
    %>
    <nav>
      <a href="indexProduto.jsp" class="ativo">INÍCIO</a>
      <a href="CafeteriaController?operacao=Listar">CARDÁPIO</a>
      <a href="cafeteria.html">CAFETERIA</a>
      <a href="remocaoUsuario.html">LOGOUT</a>
    </nav>
  </header>

  <main class="container">
    <section class="lado-esquerdo">
      <img src="img/xicara.png" alt="Xícara desenhada" class="xicara">
    </section>
    <section class="lado-direito">
      <img src="img/cafe.png" alt="Café ambiente" class="foto-cafe">
    </section>
  </main>
</body>
</html>