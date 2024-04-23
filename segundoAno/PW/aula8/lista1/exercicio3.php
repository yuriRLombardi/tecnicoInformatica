<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel="stylesheet" href="estilo.css"/>
    <meta charset="UTF-8"/>
    <title>Exercicio3</title>
</head>
<body>
<div>
    <form method="get">
    <fieldset style="border: 1px solid black;"> 
        <legend style="font: 12pt bold;">Jogo com o prêmio de  R$ 1500.000,00</legend>
        <fieldset style="border: 1px solid black;">
        <label for = "inome1">Nome do primeiro colocado:</label><input type="text" min="0" placeholder="Digite o nome" id="inome1" name="nome1" required><br>
        <label for= "ipontos1">Pontos:</label><input type="text" min="0" placeholder="Digite os pontos totais" id="ipontos1" name="pontos1" required><br>
        </fieldset>
        <fieldset style="border: 1px solid black;">
        <label for = "inome2">Nome do segundo colocado:</label><input type="text" min="0" placeholder="Digite o nome" id="inome2" name="nome2" required><br>
        <label for= "ipontos2">Pontos:</label><input type="text" min="0" placeholder="Digite os pontos totais" id="ipontos2" name="pontos2"><br>
        </fieldset>
        <fieldset style="border: 1px solid black;">
        <label for = "inome3">Nome do terceiro colocado:</label><input type="text" min="0" placeholder="Digite o nome" id="inome3" name="nome3" required><br>
        <label for= "ipontos3">Pontos:</label><input type="text" min="0" placeholder="Digite os pontos totais" id="ipontos3" name="pontos3" required><br>
        </fieldset>
        <input type="submit" value="Receber">
    </fieldset>
    </form>
    <?php
    if (isset($_GET["nome1"])&& isset($_GET["nome2"]) && isset($_GET["nome3"])&& isset($_GET["pontos1"]) && isset($_GET["pontos2"])&& isset($_GET["pontos3"])){
        $nome1 = $_GET["nome1"];
        $nome2 = $_GET["nome2"];
        $nome3 = $_GET["nome3"];
        $pontos1 = $_GET["pontos1"];
        $pontos2 = $_GET["pontos2"];
        $pontos3 = $_GET["pontos3"];

        $pontosTot = $pontos1+$pontos2+$pontos3;

        $premio1 = ($pontosTot-$pontos1)*1500000;
        $premio2 = ($pontosTot-$pontos2)*1500000;
        $premio3 = ($pontosTot-$pontos3)*1500000;

        echo"<h2>INFORMAÇÕES DOS PRÊMIOS</h2><br>";
        echo"<span style='color:red;'>O $nome1 recebeu o prêmio de R$ $premio1</span><br>";
        echo"<span style='color:green;'>O $nome2 recebeu o prêmio de R$ $premio2</span><br>";
        echo"<span style='color:blue;'>O $nome3 recebeu o prêmio de R$ $premio3</span><br>";
    }
    ?>
</div>
</body>
</html>