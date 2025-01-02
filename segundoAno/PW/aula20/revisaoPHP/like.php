<html>
    <form action="" method="get">
        Informe o nome do amigo: <input type="text" name="nome">
        <input type="submit" value="Buscar">
    </form>
</html>
<?php
    if (isset($_GET['nome'])) {
        $nome = $_GET['nome'];
        $conectar = mysqli_connect('localhost','root','','amigos');
        $buscar = mysqli_query($conectar,"SELECT * FROM pwbb WHERE nome like '%$nome%'");
        if (mysqli_num_rows($buscar) == 0) {
            echo "Nome do amigo não encontrado";
        }
        else{
            echo "<table border=1>";
            echo "<th>ID</th><th>Nome</th><th>Nick</th><th>Data Nascimento</th><th>Cidade Nasc</th><th>Cidade Mora</th><th>E-mail</th><th>Cor</th><th>Time</th><th>Óculos</th><th>Signo</th><tr>";
            while ($vetor = mysqli_fetch_array($buscar)) {
                for ($i=0; $i < 11; $i++) { 
                    echo "<td>".$vetor[$i]."</td>";
                }
                echo "<tr>";
            }
            echo "</table>";
        }
    }
?>