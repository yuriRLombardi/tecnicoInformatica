<html>
    <form action="" method="get">
        Numero 1:<input type="number" name="n1" id=""><br>
        Numero 2:<input type="number" name="n2" id=""><br>
        <input type = "submit" value = "Enviar">
    </form>
</html>
<?php
if(isset($_GET['n1']) && isset($_GET['n2'])){
    $n1 = $_GET['n1'];
    $n2 = $_GET['n2'];
    $soma = $n1 + $n2;
    $arq = fopen("teste.txt","a");
    fwrite($arq,$n1 . " + " . $n2." = ". $soma . chr(13));
    echo "<hr><p>O resultado da soma foi salvo</p><hr>";
    fclose($arq);
}
?>