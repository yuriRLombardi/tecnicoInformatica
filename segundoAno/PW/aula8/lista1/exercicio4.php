<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel="stylesheet" href="estilo.css"/>
    <meta charset="UTF-8"/>
    <title>Exercicio4</title>
</head>
<body>
<div>
    <form method="get">
        <fieldset style="border: 1px solid black;">
        <legend style="font: 12pt bold;">Categoria de Atletas</legend>
        <label for = "ipeso">Peso:</label><input type="text" min="0" placeholder="Digite seu peso" id="ipeso" name="peso" required><br>
        <label for= "ialtura">Altura:</label><input type="text" min="0" placeholder="Digite sua altura" id="ialtura" name="altura" required><br>
        <input type="submit" value="Calcular">
        </fieldset>
    </form>
    <?php
    if (isset($_GET["peso"])&& isset($_GET["altura"])){
        $peso = str_replace(",",".",$_GET["peso"]);
        $altura = str_replace(',', '.', $_GET["altura"]);


        if (($peso >= 50 && $peso<60) && ($altura < 1.70)){
            echo "Sua categoria é: Novato";
        }
        else if(($peso >= 60 && $peso<=80) && ($altura >= 1.70 && $altura < 1.90)) {
            echo "Sua categoria é: Profissonal";
        }
        else{
            echo "Sua categoria é: Amador";
        }
    }
    ?>
</div>
</body>
</html>