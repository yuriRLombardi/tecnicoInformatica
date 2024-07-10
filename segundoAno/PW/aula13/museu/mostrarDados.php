<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apresentação de Dados</title>
    <link rel="stylesheet" href="estilo.css">
    <style>
        div{
            border: solid black 1px;
            border-radius: 10px;
            box-shadow: 1px 1px 1px black;
        }
        img{
            border: 5px double brown;
            box-shadow: 1px 1px 1px black;
        }
    </style>
</head>
<body>
    <header>Obras Registradas</header>
    <section>
        <?php
            $arquivo = fopen("obras.txt","r");
            $leitura = fread($arquivo, "100000");
            echo nl2br($leitura);
            fseek($arquivo,0);
            fclose($arquivo);
        ?>
        <a href="menu.php"><button>Voltar ao menu</button></a>
    </section>
</body>
</html>