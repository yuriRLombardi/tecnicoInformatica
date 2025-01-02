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
            <form action="" method="post">
            <label for="sel">Selecione o ID do Produto que deseja excluir:</label>
            <select name="sel" id="sel">
                <?php 
                    require "conexao.php";
                    $query = mysqli_query($conexao,"SELECT * FROM `produtos`");
                    while ($array = mysqli_fetch_array($query)){
                        echo "<option value = '".$array[0]."'>".$array['id']."</option>";
                    }
                ?>
            </select>
            <input type="submit" value="Deletar">
            </form>
            <?php 
                if(isset($_POST['sel'])){
                    $id = $_POST['sel'];
                    $resultado = mysqli_query($conexao,"DELETE FROM produtos  WHERE id = $id");
                    if ($resultado == true) {
                        echo "<script>alert('Deletado');</script>";
                    } else {
                        echo "<script>alert('Produto Cadastrado '".mysqli_error($conexao)."')</script>";
                    }
                    
                }  
            ?>
        </div>
    </section>
</body>