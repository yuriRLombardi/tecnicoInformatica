<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem-vindo</title>
</head>
<body>
	<%
		String saudacao = "Bem-vindo(a) à minha página JSP<br>";
		out.println(saudacao);
		String desenvolvedor = "Desenvolvido por Yuri";
	%>
	<%=desenvolvedor %>
</body>
</html>