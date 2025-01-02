<?php
$conectar = mysqli_connect("localhost","root","","amigos");
$consulta = mysqli_query($conectar,"SELECT DISTINCT COR_PREFERIDA FROM pwbb ORDER BY COR_PREFERIDA");
?>
<html>
    <form method="get" action="">
    Informe Cor:
    <select name ="lista_cores" required>
        <?php
            while ($linha = mysqli_fetch_array($consulta)) {
                echo "<option value=". $linha['COR_PREFERIDA'] .">". $linha['COR_PREFERIDA'] ."</option>";
            }
        ?>
    </select><br>
    <input type="submit" value="Buscar Registros">
    </form>
</html>
<?php
    if(isset($_GET['lista_cores'])){
        $cor = $_GET['lista_cores'];
        $buscar = mysqli_query($conectar,"SELECT * FROM pwbb WHERE COR_PREFERIDA LIKE '$cor%'");
        echo "<table border = 1>";
        while ($linha = mysqli_fetch_array($buscar)) {
            echo "<td>".$linha['NOME']."</td>";
            echo "<td>".$linha[7]."</td><tr>";
        }
        echo "</table>";
    }
?> 