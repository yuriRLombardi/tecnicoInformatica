<?php
    $conectar = mysqli_connect("localhost","root","","amigos");
    if (!$conectar) {
        die("Falha na conexão: ".mysqli_connect_error());
    }
    $sql = "SELECT * FROM pwbb WHERE id = 23";
    $selecao = mysqli_query($conectar,$sql);
    if (mysqli_fetch_array($selecao) == 0) {
        echo "Amigo inexistente com esse ID";
    }
    else{
        $vetor = mysqli_fetch_array($selecao);
        echo "Nome do amigo: " . $vetor[1] . "<br>";
        echo "Foto do amigo: <br>";
        echo "<img src = '".$vetor['FOTO']."' width = '300' height = '300'>";
    }
?>