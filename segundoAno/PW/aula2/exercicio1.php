<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel = "stylesheet" href = "estilo.css">
    <meta charset="UTF-8">
    <title>Exercicio1</title>
    <style>
        span.soma{
            color:red;
        }
        span.subtracao{
            color:yellow;
        }
        span.multiplicacao{
            color:green;
        }
        span.divisao{
            color:blue;
        }
        span.total{
            font-weight:bold;
        }
    </style>
</head>
<body>
    <div>
    <?php
        $valor1 = 35;
        $valor2 = 28;
        $soma = $valor1 + $valor2;
        $subtracao = $valor1 - $valor2;
        $multiplicacao = $valor1 * $valor2;
        $divisao = $valor1 / $valor2;
        $total = $soma+$subtracao+$multiplicacao+$divisao;
        echo "A soma entre $valor1 e $valor2 é <span class='soma'>$soma</span><br>";
        echo "A subtração entre $valor1 e $valor2 é <span class= 'subtracao'>$subtracao</span><br>";
        echo "A multiplicacao entre $valor1 e $valor2 é <span class= 'multiplicacao'>$multiplicacao</span><br>";
        echo "A divisao entre $valor1 e $valor2 é <span class= 'divisao'>$divisao</span><br>";
        echo "O total é <span class= 'total'>$total</span>";
    ?>
    </div>
</body>
</html>