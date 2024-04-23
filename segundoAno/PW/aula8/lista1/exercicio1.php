<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel="stylesheet" href="estilo.css"/>
    <meta charset="UTF-8"/>
    <title>Exercicio1</title>
</head>
<body>
<div>
    <form method="get">
        <fieldset style="border: 1px solid black;">
        <legend style="font: 12pt bold;">Saldo líquido calculo</legend>
        <label for = "ireceita">Total da Receita:</label><input type="text" min="0" placeholder="Digite a receita total" id="ireceita" name="receita" required><br>
        <label for= "idespesa">Total da Despesa:</label><input type="text" min="0" placeholder="Digite a receita total" id="idespesa" name="despesa" required><br>
        <input type="submit" value="Calcular">
        </fieldset>
    </form>
    <?php
    if (isset($_GET["receita"])&& isset($_GET["despesa"])){
    
        $receita = $_GET["receita"];
        $despesa = $_GET["despesa"];
        $sl = $receita - $despesa;
        if ($sl >= 0) {
            echo"<span style = 'color: blue'>";
            echo "Seu salário liquido é $sl<br>";
            echo "Situação: Lucro";
            echo"</span>";
        }
        else{
            echo"<span style = 'color: red'>";
            echo "Seu salário liquido é $sl<br>";
            echo "Situação: Lucro";  
            echo"</span>";
        }
    }
    ?>
</div>
</body>
</html>