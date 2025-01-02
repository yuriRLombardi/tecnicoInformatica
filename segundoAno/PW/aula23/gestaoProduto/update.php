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
                    <legend>Seleção da atualização</legend>
                    <label for="sel">Selecione o ID do Produto que deseja atulizar:</label>
                    <select name="sel" id="sel">
                        <?php 
                            require 'conexao.php';
                            $query = mysqli_query($conexao,"SELECT * FROM `produtos`");
                            while ($array = mysqli_fetch_array($query)){
                            echo "<option value = '".$array[0]."'>".$array['id']."</option>";
                        }
                        ?>
                    </select><br>
                <label id="nome">Nome do Produto:</label><input type="text" id="nome" name="nome" required><br>
                <label id="desc">Descrição do Produto:</label><br><textarea name="desc" id="desc" cols="30" rows="10" required></textarea><br>
                <label id="valor">Valor:</label><input type="number" id="valor" name="valor" required><br>
                <label id="idL">ID da Loja:</label><input type="number" required id="idL" name="idL"><br>
                <input type="submit" value="Atualizar">
                </fieldset> 
            </form>
            <?php
                if (isset($_POST['nome']) && isset($_POST['desc']) && isset($_POST['valor']) && isset($_POST['idL'])) {
                    $id = $_POST['sel'];
                    $nome = $_POST['nome'];
                    $desc = $_POST['desc'];
                    $valor = $_POST['valor'];
                    $idL = $_POST['idL'];
                    $query = mysqli_query($conexao,"UPDATE `produtos` SET `nome`='$nome',`descricao`='$desc',`preco`='$valor',`loja_id`='$idL' WHERE id = $id;"); 
                    if ($query == true) {
                        echo "<script>alert('Atualizado')</script>";
                    }
                    else{
                        echo "<script>alert('Erro ao atualizar' ".mysqli_error($conexao)."')</script>";
                    }
                }
            ?>
        </div>
    </section>
</body>
</html>