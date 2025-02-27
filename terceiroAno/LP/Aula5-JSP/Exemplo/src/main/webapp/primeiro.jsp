<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Primeiro JSP</title>
	</head>
	<body>
		<h1>Hello World</h1>
		<p>o resultado de 15*4 é <%= 15 * 4 %></p>
		<p>60 é maior que 74?<%= 60 > 74 ? "Sim":"Não"%></p>
		<%
			String mensagem = "Hello World";
			mensagem =  mensagem.toUpperCase();
			out.println(mensagem);
		%>
		<p>Imprimindo com expression: <h1><%= mensagem %></h1></p>
		<h2>Números</h2>
		<%
			for(int i=1;i<10;i++)
				out.println(i+"");
		%>
		<%!
			String converterMaiusculo(String mensagem){
				return mensagem.toUpperCase();
			}
		%>
		<p>Uso de método: <%= converterMaiusculo("Carnaval") %></p>
	</body>
</html>