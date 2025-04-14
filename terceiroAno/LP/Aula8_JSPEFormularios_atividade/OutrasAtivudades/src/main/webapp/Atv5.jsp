<%@page import="java.net.Authenticator.RequestorType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.Calculador" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados</title>
</head>
<body>
	<h1>Resultados</h1>
	<%
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		int op = Integer.parseInt(request.getParameter("opera"));
		String res = "";
		switch(op){
			case 1:
				res = "Soma: "+Calculador.soma(num1, num2);
				break;
			case 2:
				res = "Subtração: "+Calculador.subtracao(num1, num2);
				break;
			case 3:
				res = "Multiplicação: "+Calculador.multiplicacao(num1, num2);
				break;
			case 4:
				res = "Divisão: "+Calculador.divisao(num1, num2);
				break;
			case 5:
				res = "Média: "+Calculador.media(num1, num2);
				break;
		}
	%>
	<h3>Números fornecidos: <%=num1 %> e <%=num2 %></h3>
	<h3>Resultado - <%= res %></h3>
</body>
</html>