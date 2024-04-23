<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Atividade</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <div>
        <form method = "POST" action = "">
            <fieldeset>
                <legend>Campo de Informações </legend>
                <label for="fname">Informe o nome do cliente:</label>
                <input type = 'text' id="fname" name="nomecli"><br>
                <label for="fcompra">Informe o valor da compra:</label>
                <input type = 'text' id="fcompra" name="valorcompra"><br>
                <label for="fpagamento">Informe a forma do pagamento(V para à vista ou P para compra à prazo):</label>
                <input type = 'text' id="fpagamento" name="pagto"><br>
                <input type = 'submit' target ="_self" value = "Calcular">
                <input type = 'reset' value = 'Limpar'>
            </fieldeset>
        </form>
        <?php
        if (isset($_POST["nomecli"]) && isset($_POST["valorcompra"])&& isset($_POST["pagto"])) {
            $nome = $_POST["nomecli"];
            $valor = $_POST["valorcompra"];
            $pagamento = $_POST["pagto"];
            echo "Olá,$nome!<br>";
            if ($pagamento == "V"|| $pagamento == "v") {
                $desconto = $valor-$valor*0.10;
                echo "Se pagar à vista sua compra no valor de R$ $valor ficará R$ $desconto<br>";
            }
            else if ($pagamento == "P" || $pagamento == "p") {
                $acrecimo = $valor+$valor*0.5;
                $parcela = $acrecimo/3;
                echo "Se pagar à prazo sua compra no valor de R$ $valor ficará R$ $acrecimo<br>";
                echo "Este valor poderá ser pago em 3x de R$ $parcela";
            }

        }
        

        ?>
    </div>
</body>
</html>