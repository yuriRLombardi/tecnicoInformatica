<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gerenciador de Notas</title>
    <style>
        body{
            background-color: blue;
            text-align: center;
            margin-left: 500px;
        }
        a{
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
            height: 500px;
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
    <header>Gerenciador De Notas</header>
    <section>
            <?php 
                $caminhoArquivo = fopen("numVisitante.txt","r+");
                $lerArquivo = fread($caminhoArquivo,10);
                $contador = $lerArquivo + 1;
                echo "<p>Números de visitantes: $contador</p>";
                fseek($caminhoArquivo,0);
                fwrite($caminhoArquivo,$contador);
                fclose($caminhoArquivo);
            ?>

            <a href="guardarDadosAlunos.php">Guardar dados</a>
            <a href="apresentarDadosAlunos.php">Apresentar dados</a>
    </section>
</body>
</html>