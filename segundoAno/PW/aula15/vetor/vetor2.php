<html>
    <!--
        Feito por: Yuri
        Data: 18/07/24
    -->
    <form method = 'post'>
            Informe um número para mostrar o dia da semana:
            <input type="number" name="valor" min = '1' max='7' placeholder="1-7" required>>
            <input type="submit" value="Verificar">
    </form>
</hmtl>
<?php 
    if (isset($_POST['valor'])) {
        $valor = $_POST['valor'];
        $diaSemana = ["Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"];
        echo "O número $valor = ".$diaSemana[$valor-1];
    }
?>