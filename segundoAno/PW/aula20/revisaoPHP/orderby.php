<html>
	<form action='' method='get'>
		Escolha o campo para ordenação:
		<!--Criação do objeto select para escolher o campo para ordenação.
		Para cada value foi colocado o nome do campo da tabela para ser usado depois com o order by do select. -->
		<select name='campo'>
			<option value='nome' default>Por nome</option>
			<option value='cidade_mora'>Por cidade que mora</option>
			<option value='cor_preferida'>Por cor preferida</option>
			<option value='time'>Por time</option>
		</select><p>
		<!--Criação do objeto select para escolher a ordem da ordenação a partir do campo definido.
		Para cada value foi colocado o tipo de ordenação. -->	
		Escolha a forma de ordenação:
		<select name='ordem'>
			<option value='asc'>Ordem Ascendente</option>
		   <option value='desc'>Ordem Decrescente</option>
		</select>
		<input type='submit' value='Buscar'>
	</form>
</html>
<?php
if (isset($_GET['campo']) && isset($_GET['ordem'])) {
    $campo = $_GET['campo'];
    $ordem = $_GET['ordem'];
    $conecxao = mysqli_connect("localhost","root","","amigos");
    $buscar = mysqli_query($conecxao,"SELECT * FROM pwbb ORDER BY ".$campo." ".$ordem." ");
    if(mysqli_num_rows($buscar)==0){
        echo "Não encontrado";
    }
    else{
        echo "<table border = 1>";
        echo "<th>ID</th><th>Nome</th><th>Nick</th><th>Data Nascimento</th><th>Cidade Nasc</th><th>Cidade Mora</th><th>E-mail</th><th>Cor</th><th>Time</th><th>Óculos</th><th>Signo</th><tr>";
        while($vetor = mysqli_fetch_array($buscar)){
            for ($i=0; $i < 11 ; $i++) { 
                echo "<td>$vetor[$i]</td>";
            }
            echo "<tr>";
        }
        echo "</table>";
    }
}
?>