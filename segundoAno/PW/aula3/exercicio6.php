<?php
    $media = (7+5)/2;
    if ($media<4) {
        echo"Média insuficiente";
    }
    elseif ($media>=4 && $media<=6) {
        echo"Resultado suficiente";
    }
    else {
        if ($media>6 && $media<=8) {
            echo"Resultado bom";
        }
        else{
            echo"Resultado excelente";
        }
    }
?>