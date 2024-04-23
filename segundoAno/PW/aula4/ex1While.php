<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel = "stylesheet" href = "estilo.css">
    <meta charset="UTF-8">
    <title>Exercicio1-while</title>
</head>
<body>
    <div>
        
        <?php
          $x = 0;
          while ($x <= 80) {
            if ($x%2==0) {
                if ($x != 80) {
                    echo "<span style='color:tomato'>$x-</span>";
                }
                else {
                    echo "<span style='color:tomato'>$x</span>"; 
                }
               
            }
            
            $x++;
          }
        ?>
    </div>
</body>
</html>