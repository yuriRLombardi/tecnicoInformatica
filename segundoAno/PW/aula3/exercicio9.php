<?php
    $A = 10;
    $B = 8;
    $C = 5;
    $ab = $A + $B;
    $ac = $A + $C;
    $bc = $B + $C;
    if (!$ab == $C && !$ac == $B && !$bc == $A) {
        echo "Os valores A,B e C não formam um triangulo<br>";
    }
    else{
        if (($A == $B && $B == $C)&&( $B == $C &&  $B == $A)) {
            echo "É um triânculo equilatéro";
        }
        elseif (($A==$B)||($A==$C)||($C==$B)) {
            echo "É um triângulo isóseles";
        }
        else {
            echo "É um triângulo escaleno";
        }
    }
?>