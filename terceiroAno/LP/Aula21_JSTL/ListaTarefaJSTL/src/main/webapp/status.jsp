<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Status</title>
	</head>
	<body>
		<h3>Status da operação</h3>
		<c:choose>
			<c:when test="${status}">
				<p>A tarefa foi ${operacao} com sucesso!</p>
			</c:when>
			<c:otherwise>
				<p>Erro! A tarefa não foi ${operacao}</p>
			</c:otherwise>
		</c:choose>
		<p><a href="indexTarefa.html">Início</a></p>
	</body>
</html>
