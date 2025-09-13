<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passagenss encontradas </title>
</head>
<body>

<% 
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String origem = (String)request.getAttribute("origem");
String destino =(String) request.getAttribute("destino");
LocalDate dataIda = LocalDate.parse((String)request.getAttribute("dataIda"));
LocalDate dataVolta = LocalDate.parse((String)request.getAttribute("dataVolta"));
int numPessoas = (int) request.getAttribute("numPessoas");


%>
<h1>Passagens aéreas encontradas</h1>

<h3>Voos de ida</h3>

<ul>
<li>Origem:<%=origem %></li>
<li>Destino:<%=destino %></li>
<li>Data:<%= dataIda.format(formato) %></li>

</ul>

<table border="1">
	<tr>
	<th>Valor</th>
	<th>Horário</th>
	</tr>
	
	<tr>
	<td>R$200</td>
	<td>13:00</td>
	</tr>
</table>
<br><br>

<h3>Voos de volta</h3>

<ul>
<li>Origem:<%=destino %></li>
<li>Destino:<%=origem %></li>
<li>Data:<%=dataVolta.format(formato) %></li>

</ul>

<table border="1">
	<tr>
	<th>Valor</th>
	<th>Horário</th>
	</tr>
	
	<tr>
	<td>R$200</td>
	<td>13:00</td>
	</tr>
</table>
<br><br>
<a href="index.jsp">Voltar</a>
</body>
</html>