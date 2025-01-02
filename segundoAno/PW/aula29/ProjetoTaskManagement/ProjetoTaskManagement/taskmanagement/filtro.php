<?php
    require_once 'conexao.php'; 
    session_start();
    $idUsuario = $_SESSION["idU"];
    $filtro = $_GET["selecao"];
        $query = "SELECT * FROM tarefas WHERE usuario_id = $idUsuario AND `status` = :filtro;";
        $stmt = $conexao -> prepare($query);
        $stmt -> bindValue(":filtro",$filtro);
        $stmt -> execute();
        if ($filtro == "IC") {
            require_once 'selecao.php';
        }
        else {
            foreach ($stmt as $valor) {
                echo '<tr>
                        <td>'.$valor["id"].'</td>
                        <td>'.$valor["titulo"].'</td>
                        <td>'.$valor["descricao"].'</td>
                        <td>'.$valor["status"].'</td>
                        <td>     
                            <button onclick="pegarIDEdit(this)" class="btn btn-sm btn-warning" data-bs-toggle="modal" data-bs-target="#editTaskModal" data-idTarefa = "'.$valor["id"].'">Editar</button>
                            <button onclick="pegarIDExcluir(this)" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#confirmDeleteModal" data-idTarefa = "'.$valor["id"].'">Excluir</button>
                        </td>
                    </tr>';
            }
        }
?>