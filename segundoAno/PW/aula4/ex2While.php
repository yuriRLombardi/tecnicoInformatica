<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel = "stylesheet" href = "estilo.css">
    <meta charset="UTF-8">
    <title>Exercicio2-while</title>
</head>
<body>
    <div>
        
        <?php
          $x = 1000;
          while ($x >= 0){
            
            
            if ($x == 0) {
                echo "$x";
            }
            else {
                echo "$x-";
            }
            $x--;
          }
        ?>
    </div>
</body>
</html>