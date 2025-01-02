<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta</title>
</head>
<body>
    <?php
        include "conexaoComBD.php";
        $consultar = mysqli_query($conexao,"select * from losamigos order by nome");
        echo "<table border='1'>";
        echo "<th>Nome</th>";
        echo "<th>E-mail<th>";
        while ($num_rows = mysqli_fetch_array($consultar)) {
            echo"<tr>";
            echo "<td>".$num_rows[1]."</td>";
            echo "<td>".$num_rows[3]."</td>";
            echo"</tr>";
        }
        echo "</table>";
        echo"<br>";
        $consultar2 = mysqli_query($conexao,"select nome,descricao from losamigos,cidade where IDcidade = cidade.id");
        echo "<table border='1'>";
        echo "<th>Nome</th>";
        echo "<th>Cidade<th>";
        while ($num_rows = mysqli_fetch_array($consultar2)) {
            echo"<tr>";
            echo "<td>".$num_rows[0]."</td>";
            echo "<td>".$num_rows[1]."</td>";
            echo"</tr>";
        }
        echo "</table>";
    ?>
</body>
</html>