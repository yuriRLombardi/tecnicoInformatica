<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String seqFibonacci(int n){
		int n1 = 0;
		int n2 = 1;
		int auxiliar = 0;
		String valores = "0 1";
		if(n <= 0){
			valores = "0 ";
		}
		else if(n == 1){
			valores = "0 ";
		}
			for(int c = 0; c <= (n-3);c++){
				auxiliar = n1 + n2;
				n1 = n2;
				n2 = auxiliar;
				valores += " "+Integer.toString(auxiliar);
			}
		return valores;
	}
	%>
	<h1>Sequência Fibonacci</h1>
	<%
		out.print("Sequência Fibonacci com 6 termos: "+seqFibonacci(6));
	%>
</body>
</html>