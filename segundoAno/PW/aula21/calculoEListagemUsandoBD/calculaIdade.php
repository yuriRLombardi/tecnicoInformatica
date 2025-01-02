<?php
  $conectar = mysqli_connect("localhost", "root", "", "amigos");
  if (!$conectar) {
      die("Falha na conexão: " . mysqli_connect_error());
  }
?>
<html>
    <body>
        <form method="get" action="">
            Informe o nome do amigo: <input type="text" name="nome"><br>
            <input type="submit" value="Buscar Idade">
        </form>
        <?php
            if (isset($_GET['nome'])) {
                $nome = $_GET['nome'];
                $buscar = mysqli_query($conectar,"SELECT * FROM pwbb WHERE nome like '%$nome%'");
                echo "<table border = 1>";
                echo "<h2>Nome e Idade</h2>";
                while ($linha = mysqli_fetch_array($buscar)){
                    $anoNiver = substr($linha[3],0,4); 
                    $anoAtual = 2024;
                    $idade = abs($anoNiver - $anoAtual);
                    echo "<td>".$linha[1]."</td><td>".$idade."</td></tr>";
                }
                echo "</table>";
            }
        ?>
    </body>
</html>
