<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Decolar</title>
</head>
<body>
	<%
		String origem = "";
		String destino = "";
		String dataIda = "";
		String dataVolta = "";
		int numPessoas = 0;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				switch(c.getName()){
					case "origem":
						origem = c.getValue();
						break;
					case "destino":
						destino = c.getValue();
						break;
					case "dataIda":
						dataIda = c.getValue();
						break;
					case "dataVolta":
						dataVolta = c.getValue();
						break;
					case "numPessoas":
						numPessoas = Integer.parseInt(c.getValue());
						break;
				}
			}
		}

	%>
	<h1>Passagens Aéreas</h1>
	<form method = "post" action = "DecolarController">		
		<label for = 'origem'>Aeroporto de origem:</label>
		<select id = 'origem' name = 'origem'>
			 <option value = "GRU" <%= origem.equals("GRU")?"selected":"" %>>GRU</option>
			 <option value = "CGH" <%= origem.equals("CGH")?"selected":"" %>>CGH</option>
			 <option value = "BSB" <%= origem.equals("BSB")?"selected":"" %>>BSB</option>
			 <option value = "GIG" <%= origem.equals("GIG")?"selected":"" %>>GIG</option>
			 <option value = "VCP" <%= origem.equals("VCP")?"selected":"" %>>VCP</option>
		 </select><br><br>
		 
		 <label for = 'destino'>Aeroporto de destino:</label>
		<select id = 'destino' name = 'destino'>
			 <option value = "GRU" <%= destino.equals("GRU")?"selected":"" %>>GRU</option>
			 <option value = "CGH" <%= destino.equals("CGH")?"selected":"" %>>CGH</option>
			 <option value = "BSB" <%= destino.equals("BSB")?"selected":"" %>>BSB</option>
			 <option value = "GIG" <%= destino.equals("GIG")?"selected":"" %>>GIG</option>
			 <option value = "VCP" <%= destino.equals("VCP")?"selected":"" %>>VCP</option>
		 </select><br><br>
		 
		<label for = 'dataIda'>Data de ida:</label>
		<input type = 'date' name = 'dataIda' id = 'dataIda' value="<%=dataIda %>"> <br><br>
		
		<label for = 'dataVolta'>Data de volta:</label>
		<input type = 'date' name = 'dataVolta' id = 'dataVolta' value="<%=dataVolta %>"> <br><br>
		
		<label for = 'numPessoas'>Numero de pessoa:</label>
		<input type = 'number' id = 'numPessoas' name = 'numPessoas' value="<%=numPessoas %>" min="1" step="1"><br><br>
		
		<input type = 'submit' value = 'Pesquisar'>
	
	</form>
</body>
</html>