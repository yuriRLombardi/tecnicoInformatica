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
		<title>JSTL I18N</title>
	</head>
	<body>
	<a href="teste_i18n.jsp?idioma=pt_BR"><img src="brazil.png" height="20"/></a>
	<a href="teste_i18n.jsp?idioma=en_US"><img src="usa.png" height="20"/></a>
	<a href="teste_i18n.jsp?idioma=es_ES"><img src="spain.png" height="20"/></a>
	<a href="teste_i18n.jsp?idioma=ba_BA"><img src="bangladesh.png" height="20"/></a>
	<br><br><br>
		<p>
			<fmt:message key="saudacao">
				<fmt:param value="Tamires"/>
			</fmt:message>
		</p>
		<p><fmt:message key="boasVindas"/></p>
	</body>
</html>