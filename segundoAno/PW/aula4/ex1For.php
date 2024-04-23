<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel = "stylesheet" href = "estilo.css">
    <meta charset="UTF-8">
    <title>Exercicio2-For</title>
</head>
<body>
    <div>
        
        <?php
            for($i =50;$i>=0;$i--){
                if ($i%2 == 0) {
                    if ($i != 0) {
                        echo"$i-";
                    }
                    else {
                        echo"$i";
                    }
                    
                }
            }
        ?>
    </div>
</body>
</html>