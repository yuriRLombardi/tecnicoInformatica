<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="atividades.Calculadora" %>
<%@ page import="atividades.AnoBissexto" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Calculadora e Ano Bissexto</title>
	</head>
	<body>
		<h1>Calculadora</h1>
		<p>Operações com os números 7 e 8</p>
		<p>Soma = <%=Calculadora.soma(7, 8) %></p>
		<p>Subtração = <%=Calculadora.subtracao(7, 8) %></p>
		<p>Divisão = <%=Calculadora.divisao(7, 8) %></p>
		<p>Multiplicação = <%=Calculadora.multiplicacao(7, 8) %></p>
		<p>Média = <%=Calculadora.media(7, 8) %></p>
		
		<h1>Ano Bissexto</h1>
		<p>O ano 2025,2000,1880,1783 e o ano 2020 são Bissexto?</p>
		<p>2025 <%=AnoBissexto.VerAnoBissexto(2025)?" é ano Bissexto":" não é ano Bissexto" %></p>
		<p>2020 <%=AnoBissexto.VerAnoBissexto(2020)?" é ano Bissexto":" não é ano Bissexto" %></p>
		<p>2000 <%=AnoBissexto.VerAnoBissexto(2000)?" é ano Bissexto":" não é ano Bissexto" %></p>
		<p>1880 <%=AnoBissexto.VerAnoBissexto(1880)?" é ano Bissexto":" não é ano Bissexto" %></p>
		<p>1783 <%=AnoBissexto.VerAnoBissexto(1783)?" é ano Bissexto":" não é ano Bissexto" %></p>
	</body>
</html>