<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livros Armazenados</title>
</head>
<body>
    <?php
        $conectar = mysqli_connect("localhost","root","","provaturmab");
        if (!$conectar) {
            die("Não conectado ao BD");
        }
        $selecionar = mysqli_query($conectar,"SELECT * FROM livro");
        echo"<table border = '1'>";
        echo"<caption style = 'font:20pt;'>Tabela com Dados de Livros</caption>";
        echo"<th>Codigo Livro</th><th>Título</th><th>Editora</th><th>Edição</th><th>AnoPublicacao</th><th>Autores</th><th>Assuntos</th>";
        while ($vetor = mysqli_fetch_array($selecionar)) {
            echo"<tr>";
            echo"<td>".$vetor[0]."</td>";
            echo"<td>".$vetor[1]."</td>";
            echo"<td>".$vetor[2]."</td>";
            echo"<td>".$vetor[3]."</td>";
            echo"<td>".$vetor[4]."</td>";
            echo"<td>".$vetor[5]."</td>";
            echo"<td>".$vetor[6]."</td>";
        }
        echo"</table>";
    ?>
</body>
</html>