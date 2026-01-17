<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultado do Jogo</title>
		<style type="text/css">
			div.jogo{
				padding: 10px;
				border: 5px #0080c0 solid;
				text-align: center;
				width: 150px;
				position: relative; 
			}
			
			div.jogo p{
				color: #0080c0;
				font-size: 16pt;
			}
			div.res{
				padding: 10px;
				border: 5px #0080c0 dotted;
				text-align: center;
				width: 150px;
				position: relative;
			}
			div#perdeu{
				color: red;
			}
			div#venceu{
				color: green;
			}
		</style>
	</head>
	<body>
		<div class="jogo" id="humam">
			<p>Jogador :</p>
			${jogadaHuman}
		</div>
		<div class="jogo" id="bot">
			<p>Computador:</p> 
			${jogadaBot}
		</div>
		<p>
			<c:choose>
				<c:when test="${jogadaHuman == 'Pedra' && jogadaBot == 'Papel'}">
					<div class = "res" id="perdeu">
						Você Perdeu
					</div>
				</c:when>
				<c:when test="${jogadaHuman == 'Papel' && jogadaBot == 'Tesoura'}">
					<div class = "res" id="perdeu">
						Você Perdeu
					</div>
				</c:when>
				<c:when test="${jogadaHuman == 'Tesoura' && jogadaBot == 'Pedra'}">
					<div class = "res" id="perdeu">
						Você Perdeu
					</div>
				</c:when>
				<c:when test="${jogadaHuman == jogadaBot}">
					<div class = "res">
						Empate
					</div>
				</c:when>
				<c:otherwise>
					<div class = "res" id="venceu">
						Você venceu
					</div>
				</c:otherwise>
			</c:choose>
		</p>
	</body>
</html>