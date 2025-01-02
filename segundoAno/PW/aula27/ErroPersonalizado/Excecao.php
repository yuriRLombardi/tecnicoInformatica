<?php 
    class Excecao extends Exception{
        public function  exibirMensagem($num1,$num2){
            try{
                $div = $num1/$num2;
                echo $div;
            }
            catch(DivisionByZeroError $d){
                echo "<span style = 'color:red;'>Erro Aritmétrico: $d </span><br>";
            }
            catch(TypeError $p){
                echo "<span style = 'color:red;'>Erro De Tipos: $p </span><br>";
            }
        }
    }
?>