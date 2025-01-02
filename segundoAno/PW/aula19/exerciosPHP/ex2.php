<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>Listagem de Amigos Pela cor Preferida</h1>
    <form method = "get" action = "">
        <label>Informe uma cor: <input type="text" name="cor"></label>
        <input type ="submit" value = "Enviar">


    </form>
    <?php
    if(isset($_GET["cor"])){
        $cor = $_GET["cor"];
        $conexao = mysqli_connect("localhost" ,"root" , "", "amigos");
        $listagem = mysqli_query($conexao, "SELECT nome, cor_preferida  FROM  pwbb WHERE cor_preferida = '$cor' order by nome;");
        if(mysqli_num_rows($listagem) == 0 ){
            echo"Desculpe a cor não foi encontrada \u{1F614}";
        }
        else{
            echo "<table border=1>";
            echo "<th>Nome</th><th>Cor Preferida</th>";
            
                  while($vetor = mysqli_fetch_array($listagem)){	
                    echo"<tr>";		
                for($i=0;$i<=1;$i++){
                        echo "<td>$vetor[$i]</td>";
                    }
                    echo "</tr>";
                }
                echo "</table>";
        }
    }
    
    ?>

</body>
</html>