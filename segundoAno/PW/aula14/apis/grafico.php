<!DOCTYPE html>
<html lang="pt-Br">
<head>
    <!--
    Feito por: Yuri
    Data: 11/07/24
    -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gráfico de gastos do 1ºSemestre </title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <header>Gráfico de gastos do 1ºSemestre</header>
    <section>
        <div>
            <?php
                /*
                Programa que pega dados e os transforma 
                em gráfico de pizza
                Feito por: Yuri
                Data: 11/07/24
                */
                $meses = [$_POST['jan'],$_POST['fev'],$_POST['mar'],$_POST['abr'],$_POST['mai'],$_POST['jun']];
                $soma = 0;
                for($c = 0;$c < sizeof($meses);$c++){
                    $soma += $meses[$c];
                }
                echo "<img src = https://image-charts.com/chart?cht=pd&chs=500x300&chd=a:$meses[0],$meses[1],$meses[2],$meses[3],$meses[4],$meses[5]&chan&chdl=Janeiro|Fevereiro|Março|Abril|Maio|Junho&chli=$soma-R$&chl=$meses[0]R$|$meses[1]R$|$meses[2]R$|$meses[3]R$|$meses[4]R$|$meses[5]R$&chco=01FF1A>";
            ?>
        </div>
    </section>
</body>
</html>