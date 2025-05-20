<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<% 
		
			String numInvertido = (String)request.getAttribute("numeroNovo");
			
		
		%>
		
			<p>O numero invertido é:  <%=numInvertido %></p>
	</body>
</html>