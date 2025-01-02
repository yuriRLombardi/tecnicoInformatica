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
                    <fieldset>
                        <legend>Cadastro de Produto</legend>
                        <label id="nome">Nome do Produto:</label><input type="text" id="nome" name="nome" required><br>
                        <label id="desc">Descrição do Produto:</label><br><textarea name="desc" id="desc" cols="30" rows="10" required></textarea><br>
                        <label id="valor">Valor:</label><input type="number" id="valor" name="valor" required><br>
                        <label id="idL">ID da Loja:</label><input type="number" required id="idL" name="idL"><br>
                        <input type="submit" value="Cadastrar">
                    </fieldset>
                </form>
            </div>
            <?php
                if (isset($_POST['nome']) && isset($_POST['desc']) && isset($_POST['valor']) && isset($_POST['idL'])) {
                    require 'conexao.php';
                    $nome = $_POST['nome'];
                    $desc = $_POST['desc'];
                    $valor = $_POST['valor'];
                    $idL = $_POST['idL'];
                    $query = mysqli_query($conexao,"INSERT INTO `produtos` (`nome`, `descricao`, `preco`, `loja_id`) VALUES ('$nome','$desc','$valor',$idL)"); 
                    if ($query == true) {
                        echo "<script>alert('Produto Cadastrado');</script>";
                    }
                    else{
                        echo "<script>alert('Erro ao cadastrar o produto ".mysqli_error($conexao)."')"."</script> ";
                    }
                }
                ?>
    </section>
</body>