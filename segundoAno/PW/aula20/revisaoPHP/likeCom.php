<html>
	<form action='' method='get'>
		Escolha o mês de aniversário:
		<!-- Foi criado um select com os meses do ano. Observem que cada value equivale ao mês que será usado para busca no banco de dados. -->
		<select name='niver'>
			<option value='01'>Janeiro</option>
			<option value='02'>Fevereiro</option>
			<option value='03'>Março</option>
			<option value='04'>Abril</option>
			<option value='05'>Maio</option>
			<option value='06'>Junho</option>
			<option value='07'>Julho</option>
			<option value='08'>Agosto</option>
			<option value='09'>Setembro</option>
			<option value='10'>Outubro</option>
			<option value='11'>Novembro</option>
			<option value='12'>Dezembro</option>
		</select>
		<input type='submit' value='Buscar'>
	</form>


</html>

<?php
if($_GET['niver']){
    $niver = $_GET['niver'];
    $conectar = mysqli_connect('localhost','root','','amigos');
    $buscar = mysqli_query($conectar,"SELECT * FROM pwbb WHERE data_nascimento like '____-$niver-__'");
    if(mysqli_num_rows($buscar)==0){
        echo "Mês não encontrado";
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