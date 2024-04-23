<?php
    $n1 = 5;
    $n2 = 8;
    $media = ($n1*2+$n2*3)/5;
    echo"Sua média é $media<br>";
    if ($media>=6) {
        echo "Situação aluno: Aprovado por média";
    }
    else if($media<6 && $media>=2){
        echo "Situação aluno: Em recuperação";
    }
    else{
        echo "Situação aluno: Reprovado";
    }
?>