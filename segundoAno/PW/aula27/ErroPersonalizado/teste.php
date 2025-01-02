<?php 
    include 'Excecao.php';
    $excecao = new Excecao();
    echo"<h3>Erro de divisão por zero</h3>";
    $excecao->exibirMensagem(0,0);
    echo"<h3>Erro de Tipos</h3>";
    $excecao->exibirMensagem(0,"Ola");
?>