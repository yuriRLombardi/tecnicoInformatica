<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel = "stylesheet" href = "estilo.css">
    <meta charset="UTF-8">
    <title>Exercicio1-Do_while</title>
</head>
<body>
    <div>
        
        <?php
        $roda=0;
          do {
            $x = rand(1,10);
            if ($x%2 == 0) {
                echo "$x é par<br>";
            }
            else {
                echo "$x é ímpar<br>";
            }
            $roda++;
          } while ($roda < 10);
        ?>
    </div>
</body>
</html>