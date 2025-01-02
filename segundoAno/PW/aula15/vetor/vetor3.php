<html>
    <!--
        Ler 5 números e armazenar em um vetor. Mostrar na tela apenas os números
        nas posições impares
        Feito por: Yuri
        Data: 18/07/24
    -->
    <form method = 'post'>
            Informe 5 números inteiros:<br>
            Posição 0:<input type="number" name="n1" required><br>
            Posição 1:<input type="number" name="n2" required><br>
            Posição 2:<input type="number" name="n3" required><br>
            Posição 3:<input type="number" name="n4" required><br>
            Posição 4:<input type="number" name="n5" required><br>
            <input type="submit" value="Calcular">
    </form>
</hmtl>
<?php 
    if (isset($_POST['n1'])) {
        for ($i=0; $i < 5; $i++) { 
            $vetor[$i] = $_POST['n'.$i+1];
        }
        echo "<p>Imprimindo valores nos indíces impares</p>";
        for($i=0; $i < 5; $i++){
            if ($i%2 != 0) {
                echo "Valor $vetor[$i] na posição $i<br>";
            }
        }
    }
?>