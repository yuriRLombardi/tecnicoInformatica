<?php
    try{
        require_once 'conexao.php';
        session_start();
        $nome = $_POST["editTaskName"];
        $descricao = $_POST["editTaskDescription"];
        $status = $_POST["editTaskStatus"];
        $idUsuario  = $_SESSION['idU'];
        $idTarefaEdit = $_POST['idTarefaEdit'];
        $edicao = 
        "UPDATE
            `tarefas`
        SET
            `titulo` = :nome,
            `descricao` = :descricao,
            `status` = :situa
        WHERE
            `usuario_id` = :idUsuario AND id = :idTarefa;";
        $stmt = $conexao -> prepare($edicao);
        $stmt -> bindValue(":nome",$nome);
        $stmt -> bindValue(":descricao",$descricao);
        $stmt -> bindValue(":situa",$status);
        $stmt -> bindValue(":idUsuario",$idUsuario);
        $stmt -> bindValue(":idTarefa",$idTarefaEdit);
        $stmt -> execute();
        header("location:tasks.php");
    }
    catch(PDOException $e){
        echo 'Erro: ' . $e->getCode() . ' Mensagem: ' . $e->getMessage();
    }
?>