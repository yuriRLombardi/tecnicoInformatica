<!--
    Programa que irá gerar um vetor com números de 1 até 10. O vetor terá tamanho 10.
    A partir do formulário, o usuário entra com o número e será verificado em quais 
    posições o número foi encontrado 
    Feito por: Yuri
    Data: 18/07/24
-->
<html>
    <form method = 'post'>
        Qual valor a ser procurado no vetor de 1 até 10?
        <input type="number" name="valor" min = '1' max='10' required>
        <input type="submit" value="Procurar">
    </form>
</html>
<?php 
    if (isset($_POST['valor'])) {
        $valor = $_POST['valor'];
        for ($i=0; $i <= 9 ; $i++) { 
           $vetor[$i] = rand(1,10);
        }
        for ($i=0; $i <= 9 ; $i++) { 
            if ($valor == $vetor[$i]) {
                echo "$valor encontrado na posição $i<br>";
            }
        }
        echo"<p>Impressão do vetor gerado</p>";
        for ($i=0; $i <= 9 ; $i++) { 
            echo "Valor $vetor[$i]  na  posição $i<br>";
        }
    }
?>