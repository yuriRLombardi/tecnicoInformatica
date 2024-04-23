<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculo</title>
</head>
<body>
    <div>
    <?php
    if (isset($_GET["link"])) {
        $link = $_GET["link"];
        $valor1 = $_GET["numero1"];
        $valor2 = $_GET["numero2"];
        switch($link){
            case 01:
                $soma = $valor1+$valor2;
                echo "A soma é $soma<br>";
                break;
            case 02:
                $subtracao = $valor1-$valor2;
                echo "A soma é $subtracao<br>";
                break;
            default:
            echo"ERRO<br>";
        }
    }
    ?>
    <a href="menu.php">Voltar</a>
    </div>
</body>
</html>