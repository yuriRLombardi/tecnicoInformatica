<?php
    try {
        require_once "conexao.php";
        session_start();
        $idUsuario = $_SESSION['idU'];
        $idTarefaExcluir = $_POST['idTarefaExcluir'];
        $deletar = "DELETE FROM `tarefas` WHERE :idUsuario AND id = :idTarefaExcluir";
        $stmt = $conexao -> prepare($deletar);
        $stmt -> bindValue(":idUsuario",$idUsuario);
        $stmt -> bindValue(":idTarefaExcluir",$idTarefaExcluir);
        $stmt -> execute();
        header("location:tasks.php");
        }
    catch(PDOException $e){
        echo 'Erro: ' . $e->getCode() . ' Mensagem: ' . $e->getMessage();
    }
?>