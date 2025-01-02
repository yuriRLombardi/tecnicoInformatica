<?php
    try{
        require_once 'conexao.php';
        session_start();
        $nome = $_POST["taskName"];
        $descricao = $_POST["taskDescription"];
        $status = $_POST["taskStatus"];
        $idUsuario  = $_SESSION['idU'];
        $adicao = 
        "INSERT INTO `tarefas`(
            `usuario_id`,
            `titulo`,
            `descricao`,
            `status`
        )
        VALUES(
            :idUsuario,
            :nome,
            :descricao,
            :situa
        )";
        $stmt = $conexao -> prepare($adicao);
        $stmt -> bindValue(":idUsuario",$idUsuario);
        $stmt -> bindValue(":nome",$nome);
        $stmt -> bindValue(":descricao",$descricao);
        $stmt -> bindValue(":situa",$status);
        $stmt -> execute();
        header("location:tasks.php");
    }
    catch(PDOException $e){
        echo "Error: ".$e;
    }
?>