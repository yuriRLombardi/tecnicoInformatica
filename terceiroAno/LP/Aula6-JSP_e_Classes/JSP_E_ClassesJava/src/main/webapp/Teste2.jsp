<%@page import="atividades.Bhaskara"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate,atividades.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcular Idade e Bhaskara</title>
</head>
<body>
	<h1>Calcular Idade</h1>
	<%
		Pessoa p1 = new Pessoa("Albert Einstein",LocalDate.parse("1879-03-14"));
		Pessoa p2 = new Pessoa("Isaac Newton",LocalDate.parse("1643-01-04"));
	%>
	<p>Albert Einstein - idade se tivesse vivo ainda: <%= p1.calcularIdade() %> anos</p>
	<p>Isaac Newton - idade se tivesse vivo ainda: <%= p2.calcularIdade() %> anos</p>
	<h1>Bhaskara</h1>
	<%
		Bhaskara b1 = new Bhaskara(1,2,3);	
		Bhaskara b2 = new Bhaskara(0,9,3);
		Bhaskara b3 = new Bhaskara(2,9,-3);
		Bhaskara b4 = new Bhaskara(3,6,3);
		Bhaskara b5 = new Bhaskara(-2,6,-1);
	%>
	<p>Equação1: 1x<sup>2</sup>+2x+3 = 0 &rarr; raizes: <%= b1.calcularRaizes() %></p>
	<p>Equação2: 0x<sup>2</sup>+9x+3 = 0 &rarr;  raizes: <%= b2.calcularRaizes() %></p>
	<p>Equação3: 2x<sup>2</sup>+9x-3 = 0 &rarr; raizes: <%= b3.calcularRaizes() %></p>
	<p>Equação4: 3x<sup>2</sup>+6x+3 = 0 &rarr; raizes: <%= b4.calcularRaizes() %></p>
	<p>Equação5: -2x<sup>2</sup>+6x-1 = 0 &rarr; raizes: <%= b5.calcularRaizes() %></p>
</body>
</html>