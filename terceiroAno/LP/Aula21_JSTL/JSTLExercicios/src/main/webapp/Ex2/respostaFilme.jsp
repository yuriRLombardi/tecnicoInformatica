<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ tagliburi="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Filmes</title>
</head>
	<body>
		<h3>Filmes</h3>
		<p>Os filmes escolhidos foi: </p>
		<ul>
			<%
				String[] filmesEscolhidos = (String[]) request.getAttribute("filmes");
				for(int i = 0;i < filmesEscolhidos.length; i++){
					out.print("<li>"+filmesEscolhidos[i]+"</li>");
				}
			%>
		</ul>
	</body>
</html>