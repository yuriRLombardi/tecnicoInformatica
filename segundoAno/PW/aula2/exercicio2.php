<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Exercicio2</title>
    <style>
        body{
            background-color:green;
        }
        div{
            background-color:rgba(100,200,50,1);
            position: relative;
        }
    </style>
</head>
<body>
    <div>
        <?php
            $n1 = 1;
            $n2 = 4;
            $n3 = 5;
            $n4 = 9;
            $m = $n1+$n2+$n3+$n4/4;
            echo "A média aritimétrica entre $n1,$n2,$n3 e $n4 é igual a $m";
        ?>
    </div>
</body>
</html>