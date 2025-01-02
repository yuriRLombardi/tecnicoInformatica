
<h1>Listagem de Amigos</h1>
<h2>Nome e Data de Nascimento</h2>

<?php

$conexao = mysqli_connect("localhost" ,"root" , "", "amigos");
$listagem = mysqli_query($conexao, "SELECT nome,Date_format(DATA_NASCIMENTO, '%d/%m/%Y') FROM pwbb order by data_nascimento;");

           echo "<table border=1>";
			echo "<th>Nome</th><th>Data Nascimento</th>";
		
  			while($vetor = mysqli_fetch_array($listagem)){	
                echo"<tr>";		
			for($i=0;$i<=1;$i++){
					echo "<td>$vetor[$i]</td>";
				}
				echo "</tr>";
			}
			echo "</table>";
?>