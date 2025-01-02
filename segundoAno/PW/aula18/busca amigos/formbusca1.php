<html>
	<form action='' method='get'>
		Informe o id do amigo: <input type='number' name='id'><p>
		<input type='submit' value='Buscar'>
	</form>
</html>
<?php
/*
Objetivo do programa:
- Fazer uma busca no banco de dados a partir do campo id. Preste atenção no código e substitua os ... pelo conteúdo correto.  

Explicação das principais linhas do código:
- Linha 31: o comando mysqli_connect faz a conexão com a base de dados. Preencher corretamente os parâmetros, pelo nosso exemplo estamos usando a base de dados amigos.
- Linha 32: o comando mysqli_query irá executar um comando SQL. Neste exemplo será executado o select.
		  Faça um consulta usando um select com um where, ou seja, uma condição. Ele irá deverá buscar o id que seja igual o campo fornecido
		  pelo usuário através do formulário (id).
- Linha 33: o comando mysqli_num_rows traz a quantidade de linhas originadas pela execução do select. Se a quantidade de linhas da
		  execução do select que está na variável buscar for igual a 0, então ele não trouxe nenhuma linha, ou seja, o id não foi 
		  localizado. Passar como argumento da função mysqli_num_rows a consulta. 
- Linha 35: se o id foi localizado na tabela, então é aberta uma tabela e criadas as colunas através da tag th.
- Linha 38: o comando mysqli_fetch_array irá converter o resultado do select em um vetor para que os dados possam ser impressos no PHP. 
Utilizar a função passando como argumento a consulta ($buscar). 
- Linha 38: Criar um for para facilitar a impressão dos dados na tabela. Sabemos que um vetor tem a sua primeira posição como valor 0. 
          Então o for irá do valor 0 até o 19, já que temos 20 campos na tabela pwbb (cada posição do vetor representa uma coluna
		  da tabela).
- Linha 40: A cada passada pelo for irá imprimir um campo da tabela em cada célula da tabela que será criada. Imprimir cada célula de $vetor. 
- Linha 42: Fechou a tabela criada.
*/
	if(isset($_GET['id'])){
		$id=$_GET['id'];
		$conectar=mysqli_connect("localhost","root","","amigos",);
		$buscar=mysqli_query($conectar,"SELECT * FROM `pwbb` WHERE ID = '$id'");
		if(mysqli_num_rows($buscar) == 0)
			echo "ID do amigo não encontrado<p>";
		else{
           echo "<table border=1>";
			echo "<th>ID</th><th>Nome</th><th>Nick</th><th>Data Nascimento</th><th>Cidade Nasc</th><th>Cidade Mora</th><th>E-mail</th><th>Cor</th><th>Time</th><th>Óculos</th><th>Signo</th><tr>";
			$vetor = mysqli_fetch_array($buscar);
			for($c = 0;$c < 11; $c++){
					echo "<td>$vetor[$c]</td>";
			}
			echo "</table>";
		}			
	}
?>