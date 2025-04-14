<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
	<h1>Resultado</h1>
	<%!
	public static double calcularNota(double a, double b) {
	double c = (a * 0.6) + (b * 0.4);
	return c;
	}
	%>
	<%
		double prova = Double.parseDouble(request.getParameter("prova"));
		double trab = Double.parseDouble(request.getParameter("trab"));
		double nota = calcularNota(prova, trab);
		String status = null;

		if (nota >= 6) {
		status = "Aprovado";
		} else if (nota < 6 && nota >= 4) {
		status = "Recuperação";
		} else {
		status = "Reprova";
		}
	%>
	<h3>Nota: <%= nota %></h3>
	<h3>Status: <%= status %></h3>
</body>
</html>