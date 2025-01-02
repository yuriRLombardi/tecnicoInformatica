<?php
    $cod = $_GET['cod'];
    $nome = $_GET['nome'];
    $val = $_GET['val'];
    $conexao = mysqli_connect("localhost","root","","loja");
    $comandosSQl = mysqli_query($conexao,"INSERT INTO produto(codigo,nomeProduto,valor) VALUES($cod,'$nome',$val)");
    echo"<h1>Produto Inserido</h1>";
?>