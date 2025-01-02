<?php 
    include "conexaoComBD.php";
    $nome = $_POST["nome"];
    $celular = $_POST["celular"];
    $email = $_POST["email"];
    $data = $_POST["datanasc"];
    $cidade = $_POST["cidade"];
    mysqli_query($conexao,"insert into losamigos(nome,celular,email,datanasc,IDcidade) values('$nome','$celular','$email','$data','$cidade')");
    echo 'Amigo salvo';
?>