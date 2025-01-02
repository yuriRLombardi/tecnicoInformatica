<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercicio 2</title>
</head>
<body>
    <?php
        $array =[2,4,6,8,10];
        $array2 =[];

        for ($i= 0; $i < 5 ; $i++) { 
           $array2[$i] = $array[$i]*2; 
        }
        echo"<p>Valores da 1º vetor:</p>";   
        for ($i=0; $i < 5; $i++) { 
            echo"<p>$array[$i] </p>";   
        }
        echo"<p>Valores da 2º vetor:</p>";
        for ($i=0; $i < 5; $i++) { 
            echo"<p>$array2[$i]</p>";
        }
    ?>
</body>
</html>