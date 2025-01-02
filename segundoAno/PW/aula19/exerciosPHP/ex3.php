
<h1>Consulta de registros</h1>
<h2>O aluno mora em "Hortolândia" e nasceu em "Campinas" Ou torce para o "São Paulo" e não usa óculos</h2>

<?php
  $conexao = mysqli_connect("localhost" ,"root" , "", "amigos");
  $listagem = mysqli_query($conexao, "SELECT * FROM  pwbb WHERE cidade_mora = 'Campinas' and cidade_nascimento = 'Hortolândia' or `time` = 'São Paulo'  and `usa_oculos` = 'N' ");
  if(mysqli_num_rows($listagem) == 0 ){
      echo"Desculpe a cor não foi encontrada \u{1F614}";
  }
  else{
      echo "<table border=1>";
      echo "<th>ID</th><th>Nome</th><th>Nick</th><th>Data Nascimento</th><th>Cidade de Nascimento</th><th>Cidade onde Mora</th><th>E-mail</th><th>Cor</th><th>Time</th><th>Usa Óculos</th><th>Signo</th>";
      
            while($vetor = mysqli_fetch_array($listagem)){
                echo"<tr>";		
          for($i=0;$i<=10;$i++){
                  echo "<td>$vetor[$i]</td>";
              }
              echo "</tr>";
          }
          echo "</table>";
  }



?>