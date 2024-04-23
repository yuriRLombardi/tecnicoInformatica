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
            $soma=0;
            for($i =1;$i<=10;$i++){
               $soma += $i;
               if ($i != 10) {
                echo"$i+";
               }
               else{
                echo"$i= ";
               }
                 
            }
            echo "$soma";
        ?>
    </div>
</body>
</html>