<?php
    $titulo = $_GET['titu'];
    $editora = $_GET['edit'];
    $edicao = $_GET['edic'];
    $ano = $_GET['anop'];
    $autor = $_GET['auto'];
    $assunto = $_GET['assu'];
    $conectar = mysqli_connect("localhost","root","","provaturmab");
    if (!$conectar) {
        die("Não conectado ao BD");
    }
    $inserir = mysqli_query($conectar,"INSERT INTO livro(Titulo,Editora,Edicao,AnoPublicacao,Autores,Assuntos) VALUES ('$titulo','$editora',$edicao,'$ano','$autor','$assunto')");
    echo "<h1>ENVIADO</h1>";
?>