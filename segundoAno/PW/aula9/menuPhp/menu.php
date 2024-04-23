<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Php</title>
</head>
<body>
    <div>
    <h1>Menu temático</h1><hr>
    <h3>Entre com dois números e em seguida escolha a opção do cálculo através do menu</h3>
    <br>
    <form method="GET" action="">
    <p>Número 1:<input type="text" id="num1" name="numero1"></p>
    <p>Número 2:<input type="text" id="num2" name="numero2"></p>
    <input type="submit" value="Escolher o cálculo">
    </form>
    </div> 
</body>
</html>
<?php
    if (isset($_GET["numero1"]) && isset($_GET["numero2"])){
        echo "<a href = 'calcula.php?link=1&numero1=$_GET[numero1]&numero2=$_GET[numero2]'>
        <input type = 'button' value='Somar'></a><br>";
        //está chamando o calcula.php e colocando 1 ao link
        echo "<a href = 'calcula.php?link=2&numero1=$_GET[numero1]&numero2=$_GET[numero2]'>
        <input type = 'button' value='Subtrair'></a><br>";
        //está chamando o calcula.php e colocando 2 ao link
    }
    ?>