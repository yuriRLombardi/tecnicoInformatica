<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="estilo.css">
    <style>
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        
        nav li {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        
        nav a {
            color: white;
            display: block;
            text-align: center;
            text-decoration: none;
        }
        nav a:hover{
            background-color: white;
            color: black;
            transition: 1s;
        }
        section{
            height: 280px;
            background-size: cover ;
            width: 1000px;
            text-align: center;
        }
        body{
            background-size: cover;
            background-image: url("Imagens/fundoMenu.png");
            background-repeat: no-repeat;
        }
        div{
            float: left;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
        section#mensagem{
            float: left;
            display: block;
            width: 250px;
            height: auto;
            border: none;
            border-radius: none;
            box-shadow: none;
        }
        .left{
            margin-left: 60px;
        }
    </style>
</head>
<body>
    <nav>
        <ul>
            <li><a href = "guardarDados.php">Resgistrar obra</a></li>
            <li><a href = "mostrarDados.php">Mostrar obras</a></li>
            <?php
                $arquivo = fopen("visitantes.txt","r+");
                $contagem = fread($arquivo,10);
                fseek($arquivo, 0);
                $contagem = $contagem + 1;
                fwrite ($arquivo , $contagem);

                
                fclose($arquivo);


                echo"<li>Número de visitantes: $contagem</li>";
            ?>
        </ul>
    </nav>
    <header>Bem vindo ao menu do museu de Obras</header>
    <section>
        <div class="left">
            <img src="Imagens/interior1.jpg">
        </div>
        <section id="mensagem">
                <p>Aqui você poderá registrar e/ou mostrar as obras digitadadas
                clicando nos botões acima do menu: "Registrar Obra"
                e "Mostrar Obras"</p>
        </section>
        </div>  
        <div>
            <img src="Imagens/interior2.jpg">
        </div>    
    </section>
</body>
</html>

