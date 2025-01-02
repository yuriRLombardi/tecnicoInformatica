<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercicio 1</title>
</head>
<body>
    <?php 
        $array1 = [2,1,3];
        $array2 = [4,5,6];
        $arraySoma = [];
        for ($i=0; $i < 3; $i++) { 
            $arraySoma[$i] = $array1[$i] + $array2[$i];
        }
        for($i=0; $i < 3; $i++){
            echo "<p>".$array1[$i]." + ".$arraySoma[$i]." = ".$array2[$i]."<p>";
        }
    ?>
</body>
</html>