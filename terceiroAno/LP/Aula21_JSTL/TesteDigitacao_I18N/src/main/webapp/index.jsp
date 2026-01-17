<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${not empty param.idioma }">
	<fmt:setLocale value="${param.idioma}" scope="application"/>
</c:if>
<fmt:setBundle basename="mensagens" scope="application"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Teste de digitação</title>
	</head>
	<body>
	<a href="index.jsp?idioma=pt_BR"><img src="brazil.png" height="20"/></a>
	<a href="index.jsp?idioma=en_US"><img src="usa.png" height="20"/></a>
	<a href="index.jsp?idioma=es_ES"><img src="spain.png" height="20"/></a>
	<a href="index.jsp?idioma=ba_BA"><img src="bangladesh.png" height="20"/></a>
	<br><br><br>
	<h1><fmt:message key="titulo"/></h1>
	<form action="TesteController" method="post">
		<p>
			<fmt:message key="texto"/>
		</p>
		<textarea rows="50" cols="50"></textarea>
		<button type= "submit" value = "iniciar" name = "botao"><fmt:message key="iniciar"/></button>
		<button type= "submit" value = "parar" name = "botao" ><fmt:message key="parar"/></button>
	</form>
		
	</body>
</html>