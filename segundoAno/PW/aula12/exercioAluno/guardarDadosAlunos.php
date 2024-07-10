<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guardar dados</title>
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
            text-align: center;
        }
        header{
            font: 18pt bold;
            background-color: white;
            border: 1px solid black;
            width: 500px;
            border-radius: 50px;
            margin-bottom: 10px ;
        }
        form{
            text-align: justify;
            margin-top: 50px;
        }
        fieldset{
            width: 250px;
            border: solid black 1px;
        }
        legend{
            font: bold 12pt;
        }
        div#res{
            text-align: left;
        }
    </style>
</head>
<body>
    <header>Guardar Dados Alunos</header>
    <section>
        <div id="dados">
            <form action="" method = "post">
            <fieldset>
                    <legend>Informações do Aluno</legend>
                    Prontuário:<input type="text" name = "prontuario"><br>
                    Nome:<input type = "text" name = "nome"><br>
                    Nota da prova: <input type="number" name="np" id="" step="0.1" max="10" min="0"><br>
                    Nota do Trabalho: <input type="number" name="nt" id="" step="0.1" max="10" min="0"><br>
                    <input type="submit" value="Enviar">
            </fieldset> 
            </form>
        </div>
        <div id="res">
            <?php
                if (isset($_POST["prontuario"]) && isset($_POST["nome"]) && isset($_POST["np"]) && isset($_POST["nt"])) {
                    $prontuario = $_POST["prontuario"];
                    $nome = $_POST["nome"];
                    $np = $_POST["np"];
                    $nt = $_POST["nt"];
                    $media = ($np + $nt)/2;
                    $caminhoArquivo = fopen("alunos.txt","a");
                    fwrite($caminhoArquivo,"<div id = res>INFORMAÇÕES DO ALUNO".chr(13));
                    fwrite($caminhoArquivo,"Prontuario: $prontuario".chr(13));
                    fwrite($caminhoArquivo,"Nome: $nome".chr(13));
                    fwrite($caminhoArquivo,"Nota da Prova: $np".chr(13));
                    fwrite($caminhoArquivo,"Nota do Trabalho $nt".chr(13));
                    if ($media >= 6) {
                        fwrite($caminhoArquivo,"Situação: Aprovado</div>".chr(13));
                    }
                    else{
                        fwrite($caminhoArquivo,"Situação: Reprovado</div>".chr(13));
                    }
                    fwrite($caminhoArquivo,chr(13));
                    echo "<p>Arquivos salvos</p>";
                    fclose($caminhoArquivo);
                    echo "<a href = 'menu.php'>Voltar</a>";
                }
            ?>
        </div>
    </section>
    
</body>
</html>