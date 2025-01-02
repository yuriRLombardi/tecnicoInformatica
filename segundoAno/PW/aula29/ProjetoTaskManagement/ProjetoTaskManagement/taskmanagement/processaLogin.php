<?php

if(!empty($_POST['username']) && !empty($_POST['password'])) {
    try {
        require_once 'conexao.php';
        $query = "select * from usuarios where";
        $query .= " usuario = :pusuario ";
        $query .= " AND senha = :psenha";

        $stmt = $conexao->prepare($query);

        $stmt->bindValue(':pusuario',$_POST['username']);
        $stmt->bindValue(':psenha',$_POST['password']);

        $stmt->execute();

        $usuario = $stmt->fetch();
        session_start();
        $_SESSION['nome'] = $usuario['usuario'];
        $_SESSION['idU'] = $usuario['id'];

        if (!empty($usuario)) {
            header('location:tasks.php');
        }
        else{
            header('location:index.php');
        }
    } catch (PDOException $e) {
        echo 'Erro: ' . $e->getCode() . ' Mensagem: ' . $e->getMessage();
    }

}
else {
    header('location:index.php');
}
?>