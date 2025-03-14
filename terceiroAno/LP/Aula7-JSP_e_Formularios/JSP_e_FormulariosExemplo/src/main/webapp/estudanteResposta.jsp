<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Olá, <%= request.getParameter("nome") %></p>
	<p>Oi,  ${param.nome}</p>
	<%
		String nomeForm = request.getParameter("nome");
		if(nomeForm.equals("")){
			out.println("<p>Bem-Vindo</p>");
		}
		else{
			out.println("<p>Bem-Vindo, "+nomeForm+"</p>");
		}
	%>
	<p>Carro: <%= request.getParameter("carros") %></p>
	<p>Idiomas do estudante:
	<% 
		String[] listaIdiomas = request.getParameterValues("idioma");
		for (String idioma : listaIdiomas) {
			out.println(idioma + " ");
		}
	%>
	</p>
</body>
</html>