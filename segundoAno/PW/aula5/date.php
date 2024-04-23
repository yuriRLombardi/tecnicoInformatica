<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Atividade</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <div>
        <?php
        //Função date():
        //data
        echo date('d/m/y')."<br>";
        echo date('D/M/Y')."<br>";    
        echo date('l/m/Y')."<br>"; 
        //horas
        date_default_timezone_set('America/Sao_Paulo');
        echo date('h:i:s')."<br>";
        echo date('H:i:s')."<br>";
        //Tradução do formado da data em português
        
setlocale(LC_TIME,'pt_BR','pt_BR.utf-8','portuguese'/*Define a localização para portugues*/);
        
        $dataAtual = strftime('%A,%d de %B de %Y',time());

        echo "$dataAtual";
        ?>
    </div>
</body>
</html>