
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link rel = "stylesheet" href = "estilo.css">
        <meta charset="UTF-8">
        <Title>Exercicio 3</Title>
    </head>
    <body>
        <div>
        <?php 
            $anoNasc = isset($_GET["an"])?$_GET["an"]:2008;
            $idade = 2024 - $anoNasc;
            $meses = $idade * 12;
            $dias = $meses * 30;
            $horas = $dias * 24;
            $min = $horas * 60;
            $segundos = $min * 60;
            echo "<h2>INFORMÇÕES SOBRE SEUS DADOS DE VIDA</h2><br>";
            echo "Idade: $idade<br>";
            echo "Meses: $meses<br>";
            echo "Dias: $dias<br>";
            echo "Horas: $horas<br>";
            echo "Minutos: $min<br>";
            echo "Segundos: $segundos";
        ?>
        </div>
    </body>
</html>