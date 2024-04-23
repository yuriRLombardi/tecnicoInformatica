<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Atividade</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <div>
        <form method = "get">
            <label for = "freceita">Informe a receita da empresa:</label>
            <input type = "text" name="receita" id="freceita" required>
            <label for = "despesa">Informe a despesa da empresa:</label>
            <input type = "text" name="despesa" id="fdespesa" required>
        </form>
        <?php 
        $receita = $_GET["receita"];
        $despesa = $_GET["despesa"];
        $saldo = $receita-$despesa;
        if ($saldo>= 0) {
            echo "Situação final: Lucro <br>";
            echo "<span style = 'color:blue'> Seu saldo $saldo</span>";
        }
        else{
            echo "Situação final: Prejuízo <br>";
            echo "<span style = 'color:red'>Seu saldo $saldo</span>";
        }
        ?>
    </div>
</body>
</html>