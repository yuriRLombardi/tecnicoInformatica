<?php
    $conectar = mysqli_connect("localhost","root","","amigos");
    if (!$conectar) {
        die("Falha ao concectar ao servidor". mysqli_connect_error());
    }
?>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserção de dados no BD</title>
</head>
<body>
    <form method="post" action="">
        <legend>Inserção de dados no BD</legend>
        ID: <input type="number" name="id" step="1" min="21"><br>
        Nome: <input type="text" name="nome"><br>
        Nick: <input type="text" name="nick"><br>
        Data de nascimento: <input type="date" format="d/m/yyyy" name="datanasc"><br>
        Cidade de nascimento: <input type="text" name="cidadenasc"><br>
        Cidade onde mora: <input type="text" name="cidademora"><br>
        Email:<input type="text" name="email"><br>
        Cor Preferida: <input type="text" name="cor"><br>
        Time: <input type="text" name="time"><br>
        Usa Óculos(S/N): <input type="text" name="usaoculos" maxlength="1" size="1"><br>
        Signo: <input type="text" name="signo"><br>
        Insira um arquivo: <input type="file" name="foto" accept="imagem/*"><br>
        <input type="submit" value="Inserir Dados"><br>
    </form>
    <?php
        if (isset($_POST["id"]) && isset($_POST["nome"]) && isset($_POST["nick"]) && isset($_POST["datanasc"]) && isset($_POST["cidadenasc"]) && isset($_POST["cidademora"]) && isset($_POST["email"]) && isset($_POST["cor"]) && isset($_POST["time"]) && isset($_POST["usaoculos"]) && isset($_POST["signo"]) && isset($_POST["foto"])) {
            $id = $_POST["id"];
            $nome = $_POST["nome"];
            $nick = $_POST["nick"];
            $datanasc =  $_POST["datanasc"];
            $cidadenasc = $_POST["cidadenasc"];
            $cidademora = $_POST["cidademora"];
            $email = $_POST["email"];
            $cor = $_POST["cor"];
            $time = $_POST["time"];
            $usaoculos = $_POST["usaoculos"];  
            $signo = $_POST["signo"];
            $foto = $_POST["foto"];
            $sql = "INSERT INTO `pwbb` (`ID`, `NOME`, `NICK`, `DATA_NASCIMENTO`, `CIDADE_NASCIMENTO`, `CIDADE_MORA`, `E_MAIL`, `COR_PREFERIDA`, `time`, `USA_OCULOS`, `SIGNO`,`FOTO`) VALUES ($id,'$nome','$nick','$datanasc','$cidadenasc','$cidademora','$email','$cor','$time','$usaoculos','$signo','$foto')";
            $insercao = mysqli_query($conectar,$sql);
            echo "<p>Dados Inseridos</p>";
        }
        else{
            echo "<p>Aguardando Dados...</p>";
        }
    ?>
</body>
</html>