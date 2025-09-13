<%@ page import="model.Presente, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Presentes</title>
</head>
<body>
		<h3>Inserir Presente</h3>
		<form action="PresenteController" method="post">
				<label id="itemId">Item: <input type="text" name="item" id="itemId"><br></label>
				<label id="valorId">Valor: <input type="number" name="valor" id="valorId" step="0.01"><br></label>
				<button type="submit">Inserir</button>
		</form>
		<h3>Lita de Presente</h3>
		<ol>
			<%
					ArrayList<Presente> lista = (ArrayList<Presente>) session.getAttribute("listaPresentes");
					if(lista != null){
						for(Presente presente : lista){
							out.print("<li>"+presente.getItem()+" - "+presente.getValor()+"</li>");
						}
					}
			%>
		</ol>
</body>
</html>