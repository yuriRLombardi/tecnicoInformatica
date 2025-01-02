<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forulario</title>
    <style>
        body{
            font: Arial 15pt;
        }
        legend{
            font: 18pt bold;
        }
        fieldset{
            width:500px;
        }
        section{
            box-shadow: 1px 1px 1px black;
            border: 1px solid black;
            background-color: white;
            width: 700px;
            margin: auto;
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <section>
        <form action="" method="post">
            <fieldset>
                <legend>Acesso ao Banco de Dados</legend>
                Login: <input type="text" name="login"><br>
                Senha:<input type="password" name="senha"><br>
                <input type="submit" value="Acessar">
            </fieldset>
        </form>
        <?php
            $login = $_POST['login'];
            $senha = $_POST['senha'];
            if ($login == 'teste' && $senha == '123456') {
                echo "<p>Acesso liberado</p>";
            }
            else{
                echo "<p>Acesso Negado</p>";
            }
        ?>
    </section>
</body>
</html>