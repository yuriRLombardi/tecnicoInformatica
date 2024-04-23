<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel="stylesheet" href="estilo.css"/>
    <meta charset="UTF-8"/>
    <title>Exercicio2</title>
</head>
<body>
<div>
    <form method="get">
        <fieldset style="border: 1px solid black;">
        <legend style="font: 12pt bold;">Gratificação de 500 reais</legend>
        <label for = "ianos">Numero de Anos na empresa:</label><input type="number" min="0" placeholder="Digite o tempo na empresa" id="ianos" name="anos" required><br>
        <label for= "idespesa">Salário:</label><input type="number" min="0" placeholder="Digite seu salário" id="isalario" name="salario" ><br>
        <input type="submit" value="Calcular">
        </fieldset>
    </form>
    <?php
    if (isset($_GET["anos"])&& isset($_GET["salario"])){
        $ano = $_GET["anos"];
        $salario = $_GET["salario"];
        if ($ano > 10) {
            $gratific = $salario+500;
            echo "Meus parabéns você recebeu a a gratificação<br>";
            echo "Seu salário agora é: $gratific";        
        }
        else{
            echo "Prêmio não recebido<br>";
            echo "Seu salário atual é: $salario";
        }
    }
    ?>
</div>
</body>
</html>