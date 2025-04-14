<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<h1>Dados Pessoais - Confirmação</h1>
			<p>Nome: <%= request.getParameter("nome") %></p>
			<p>Endereço:<%= request.getParameter("ende") %> </p>
			<p>Telefone: <%= request.getParameter("tele") %></p>
			<p>Idade:<%= request.getParameter("idade") %></p>		
		<h1>Formação</h1>
		<p>Escolaridade: <%= request.getParameter("escola") %></p>
		<p>Área do conhecimento: <%= request.getParameter("conhecimento") %></p>
		<p>Experiências Profissionais: </p>
		<ol>
			<% 
					String[] listaExper = request.getParameterValues("exper");
					
					for (String exper : listaExper) {
						out.println("<li>"+exper + "</li>");
					}
			%>	
		</ol>
	</body>
</html>