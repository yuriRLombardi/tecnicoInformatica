<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Média 3 de Números</title>
</head>
<body>
	<%!
		double media3num(int num1,int num2,int num3){
			return (num1+num2+num3)/3;		
		}
	%>
	<p>Média dos números 4; 7 e 10</p>
	<%
		out.print("<p>Resuldado: "+media3num(4,7,10)+"</p>");
	%>
</body>
</html>