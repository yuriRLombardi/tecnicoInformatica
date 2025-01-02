<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilo.css">
    <title>Gestão de Produtos</title>
</head>
<body>
    <nav>
        <h1>Gestão de Produtos</h1>
        <ul>
            <li><a href="cadastrar.php">Cadastrar Produtos</a></li>
            <li><a href="delete.php">Deletar Produtos</a></li>
            <li><a href="update.php">Atualizar Produtos</a></li>
            <li><a href="listar.php">Listar Produtos</a></li>
        </ul>
    </nav>
    <section>
        <div>
            <?php
                require "conexao.php";
                $query = mysqli_query($conexao,"SELECT * FROM `produtos`");
                echo "<table border=1>";
                echo"<caption>Produtos Armazenados</caption>";
                echo "<tr><th>ID</th><th>Nome</th><th>Descrição</th><th>Preço</th><th>ID da Loja</th></tr>";
                while($array = mysqli_fetch_array($query)){
                    for($i = 0;$i < 5;$i++){
                        echo "<td>".$array[$i]."</td>";
                    }
                    echo"<tr>";
                }
                echo "</table>";
            ?>  
        </div>
    </section>
</body>
