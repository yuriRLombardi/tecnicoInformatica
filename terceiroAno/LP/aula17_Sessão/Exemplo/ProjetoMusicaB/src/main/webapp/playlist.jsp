<%@ page import = "model.Musica, java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
			<meta charset="UTF-8">
			<title>PlayList</title>
	</head>
	<body>
			<h3>PlayList</h3>
			<ol>
			<%
					ArrayList<Musica> playlist = (ArrayList<Musica>) session.getAttribute("minhasMusicas");
					if(playlist != null){
							for(Musica item : playlist){
									out.print("<li>"+item.getNome()+" - "+item.getBanda()+" - "+item.getAno() + "</li>");
							}
					}
			%>
			</ol>
			<a href="infoMusica.html"><button>Nova Música</button></a>
	</body>
</html>