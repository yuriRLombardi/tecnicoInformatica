<!DOCTYPE html>
<html lang="pt-br">
    <!--
Prova de PW
Data: 11/04	
-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Questão 1</title>
</head>
<body>
    <form method="get" action="">
        <fieldset style="border: 1px solid black;">
            <legend style="font-weight: bold">Convertedor de números para algarismo romano</legend>
            <label for="iromano">Digite um número</label><input type="number" name="romano" id="iromano" placeholder="Digite um número inteiro">
        </fieldset>
        <?php 
        if(isset($_GET["romano"])){
            $num = $_GET["romano"];
            $I = "I";
            $V = "V";
            $X = "X";
            echo"<h1>Numero em algarismo romano</h1><br>";
            if ($num >= 1 && $num <= 10) {
                if($num >= 6 && $num <=8){
                    echo"$V";
                }
                for ($i=0; $i < $num; $i++) { 
                    if ($num == 1) {
                        echo"$I";
                        break;
                    }
                    elseif ($num > 1 && $num<=3) {
                        echo"$I";
                    }
                    else{
                        if($num == 4){
                            echo"$I$V";
                            break;
                        }
                        elseif($num == 5){
                            echo"$V";
                            break;
                        }
                        else{
                            if ($num >= 6 && $num <=8) {
                                if ($num == 6) {
                                    echo"$I";
                                    break;
                                }
                                elseif($num == 7){
                                    echo"$I$I";
                                    break;
                                }
                                else{
                                    echo"$I$I$I";
                                    break;
                                }
                            }
                            elseif($num == 9){
                                echo"$I$X";
                                break;
                            }
                            else{
                                echo"$X";
                                break;
                            }
                        }
                    }
                }
            }
            else{
                echo"Erro";
            }
        }
        ?>
    </form>
</body>
</html>