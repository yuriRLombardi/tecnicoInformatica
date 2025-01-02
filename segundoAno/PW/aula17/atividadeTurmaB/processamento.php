<?php
        $conexao = mysqli_connect("localhost" ,"root" , "" , "numeros");
        if (!$conexao) {
            echo"Erro na conexão";
        }
        else {
            $num = $_GET["num"];
            $insercao;
            if($num > 0 && $num%2 == 0){
               $insercao = mysqli_query($conexao, "insert into tipo (numero, parouimpar, pnn) values ($num, 'Par','Positivo')"); 
            }
            else if($num > 0 && $num%2 != 0){
                $insercao = mysqli_query($conexao, "insert into tipo (numero, parouimpar, pnn) values ($num, 'Impar','Positivo')"); 
            } 
            else if($num < 0 && $num%2 != 0){
                $insercao = mysqli_query($conexao, "insert into tipo (numero, parouimpar, pnn) values ($num, 'Impar','Negativo')"); 
            } 
            else if($num < 0 && $num%2 == 0){
                $insercao = mysqli_query($conexao, "insert into tipo (numero, parouimpar, pnn) values ($num, 'Par','Negativo')"); 
            } 
            else {
                $insercao = mysqli_query($conexao, "insert into tipo (numero, parouimpar, pnn) values ($num, 'Neutro','Neutro')"); 
            }
            echo"Enviado com sucesso<br>"; 
            echo"<a href = formulario.html><buttom>Voltar</buttom></a>"; 
        }
    ?>