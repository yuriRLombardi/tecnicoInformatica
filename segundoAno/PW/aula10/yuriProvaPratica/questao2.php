<!DOCTYPE html>
<html lang="pt-br">
<head>
<!--
Prova de PW
Data: 11/04	
-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Questão 1</title>
</head>
<body>
    <form method="get" action="">
        <fieldset style="border: 1px solid black;">
            <legend style="font-weight: bold">Area Retangulo</legend>
            <label for="ibase">Digite a base1</label><input type="number" name="base" id="ibase" placeholder="Digite a base do retangulo"><br>
            <label for="ialtura">Digite a altura1</label><input type="number" name="altura" id="ialtura" placeholder="Digite a altura do retangulo"><br>
            <label for="ibase2">Digite a base2</label><input type="number" name="base2" id="ibase2" placeholder="Digite a base do retangulo"><br>
            <label for="ialtura">Digite a altura2</label><input type="number" name="altura2" id="ialtura2" placeholder="Digite a altura do retangulo"><br>
            <input type = "submit" value = "Calcular">
        </fieldset>
        <?php 
        if(isset($_GET["base"]) && isset($_GET["altura"]) && isset($_GET["base2"]) && isset($_GET["altura2"])){
            $b = $_GET["base"];
            $a = $_GET["altura"];
            $b2 = $_GET["base2"];
            $a2 = $_GET["altura2"];
            $area = $b * $a;
            $area2 = $b2 * $a2;
            if ($area == $area2) {
                echo"As areas dos retangulos são iguais";
            }
            elseif($area > $area2){
                echo"A area dos retangulo1 é maior";
            }
            else{
                echo"A area dos retangulo2 é maior";
            }
        }
        ?>
</body>