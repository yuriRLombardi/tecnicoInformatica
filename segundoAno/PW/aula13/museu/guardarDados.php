<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Obras</title>
    <link rel="stylesheet" href="estilo.css">
    <style>
        fieldset{
            background-color: rgba(255, 255, 255, 0.5);
            width: 470px;
            box-shadow: 1px 1px 1px black;
        }
        fieldset legend{
            font: 18pt bold;
        }
        fieldset.ajuste{
            width: 250px;
        }
    </style>
</head>
<body>
    <section>
        <form method = "POST" enctype="multipart/form-data">
            <fieldset>
                <legend>Registro de Obra</legend>
                <p>Nome da Obra: <input type="text" name = "nome" required></p>
                <p>Tipo da Obra: 
                <select name = "tipo">
                    <option value = "Pintura" select>Pintura</option> 
                    <option value = "Telas">Telas</option>
                    <option value = "object">Objetos pessoais</option>
                    <optio value = "Moveis">Móveis</option>
                    <option value = "Relogio">Relógios</option>
                    <option value = "Escultura">Esculturas</option>
                </select>
                </p>
                <p>Ano de criação: <input type="number" name = "criacao" min="0" max="2024" required></p>
                <p>Foto: <input type="file" name = "foto"></p>
                <fieldset class="ajuste">
                    <legend>Faz parte da coleção:</legend> 
                        <input type="radio" name = "escolha" value = "Sim" id = "sim">Sim
                        <input type = "radio" name = "escolha" value = "Não" id = "nao" checked>Não<br>
                </fieldset>           
                <fieldset class = "ajuste">
                    <legend>Observações</legend> 
                    <textarea name = "observacoes"></textarea><br>
                </fieldset>
                <input type="submit" value="Enviar">
                <input type="reset" value = "Limpar">
                </fieldset>
        </form>
        <a href="menu.php"><button>Voltar ao menu</button></a>
        <?php
        if(isset($_POST["nome"]) && isset($_POST["tipo"]) && isset($_POST["criacao"]) && isset($_FILES["foto"]) && isset($_POST["escolha"]) && isset($_POST["observacoes"])){
            $nome = $_POST["nome"];
            $tipo = $_POST["tipo"];
            $criacao = $_POST["criacao"];
            $foto = $_FILES["foto"]["name"];
            $escolha = $_POST["escolha"];
            $observacoes = $_POST["observacoes"];
            $arquivo = fopen("obras.txt","a");
            $arquivoF = $_FILES["foto"];
            $arquivoFN = explode(".", $arquivoF['name']);
            if ($arquivoFN[sizeof($arquivoFN) -1] != 'jpg' && $arquivoFN[sizeof($arquivoFN) -1] != 'png'){
               echo"<p>Só arquivos png e jpg</p>";
               echo"<p>Resgitro não</p>";
            }
            else{
                move_uploaded_file($arquivoF["tmp_name"],'uploads/'.$arquivoF['name']);
                fwrite($arquivo,"<div>".chr(13));
                fwrite($arquivo,"<h1>Obra $nome</h1>".chr(13));
                fwrite($arquivo,"Tipo da Obra: $tipo".chr(13));
                fwrite($arquivo,"Ano de Criação: $criacao".chr(13));
                fwrite($arquivo,"Foto: ".chr(13)."<img src = 'uploads/$foto' width = '250' height = '250'>".chr(13));
                fwrite($arquivo,"Faz Parte da coleção?: $escolha".chr(13));
                fwrite($arquivo,"Observações:  $observacoes".chr(13));
                fwrite($arquivo,"</div>".chr(13));
                fclose($arquivo);
                echo"<p>Registro realizado</p>";
            }
        }
    ?>
    </section>
</body>


</html>


