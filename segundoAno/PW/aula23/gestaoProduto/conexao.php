<?php
    $conexao = mysqli_connect("localhost","root","","gestao");
    if (!$conexao) {
        die("Falha na conexão ".mysqli_connect_error());
    }
?>