<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apresentação dos Dados dos Alunos</title>
    <style>
        body{
            background-color: blue;
            text-align: center;
            margin-left: 500px;
        }
        a{
            margin-top: 20px ;
            padding: 10px;
            border: solid black 1px;
            text-decoration: none;
            background-color: white;
            border: 1px solid black;
        }
        a:hover{
            background-color: black;
            color: white;
            transition: 1s;
        }
        section{
            position: relative;
            border: 1px solid black;
            box-shadow: 1px 1px 1px black;
            width: 500px;
            font: 10pt;
            border-radius: 50px;
            background-color: white;
        }
        header{
            font: 18pt bold;
            background-color: white;
            border: 1px solid black;
            width: 500px;
            border-radius: 50px;
            margin-bottom: 10px ;
        }
        p{
            background-color: white;
            border: 1px solid black;
            width: 250px;
            margin-left: 120px;
        }
    </style>
</head>
<body>
    <header>Apresentação dos Dados dos Alunos</header>
    <section>
        <?php
            $caminhoArquivo = fopen("alunos.txt","r");
            $leitura = fread($caminhoArquivo,10000000);
            echo nl2br($leitura);
            echo "<a href = 'menu.php'>Voltar</a>";
            fclose($caminhoArquivo)
        ?>
    </section>
</body>
</html>