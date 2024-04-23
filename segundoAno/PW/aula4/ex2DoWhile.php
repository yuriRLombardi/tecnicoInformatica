<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel = "stylesheet" href = "estilo.css">
    <meta charset="UTF-8">
    <title>Exercicio2-Do_while</title>
</head>
<body>
    <div>
        
        <?php
        $x = 1;
        echo"<ul>Múltiplos de 3:<br>";
          do {
            if ($x%3 == 0) {
                echo"<li>$x</li>";
            }
            $x++;
          } while ($x <= 30);
          echo"</ul>";
        ?>
    </div>
</body>
</html>