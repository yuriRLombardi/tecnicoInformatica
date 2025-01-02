<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Management 1.0</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <?php
        require_once 'conexao.php';
    ?>
    <script src="script.js"></script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand d-flex align-items-center" href="#">
                <img src="logo-sistema.png" alt="Logotipo do Gerenciador de Tarefas" width="30" class="me-2">
                <span>Task Management 1.0</span>
            </a>
            <div class="d-flex align-items-center">
                <span class="me-3">Olá, <?php session_start();echo $_SESSION['nome']?></span> 
                <a href="index.php" class="btn btn-outline-secondary">Sair</a>
            </div>
        </div>
    </nav>

     <!-- Tabela com listagem de tarefas -->
    <div class="container my-5">
        <h2 class="mb-4">Lista de Tarefas</h2>
        <div class="mb-4 d-flex justify-content-between">
            <div>
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addTaskModal">Adicionar Tarefa</button>
            </div>
            <div>
                <label for="taskFilter" class="form-label">Filtrar Tarefas:</label>
                <select id="taskFilter" class="form-select"  name = "form-select" onchange="filtroTarefas(this.value)">
                    <option value="IC">Todas</option>
                    <option value="INCOMPLETA">Incompletas</option>
                    <option value="COMPLETA">Completas</option>
                </select>
            </div>
        </div>

        <table class="table table-striped" id="taskTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tarefa</th>
                    <th>Descrição</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody id="txtHint">
                <?php
                    require_once 'selecao.php';
                ?>
            </tbody>
        </table>
    </div>

    <!-- Modal de Adição de Tarefa -->
    <div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Adicionar Nova Tarefa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form method="POST" action="adicaoTarefa.php">
                        <div class="mb-3">
                            <label for="taskName" class="form-label">Nome da Tarefa</label>
                            <input type="text" class="form-control" id="taskName" name="taskName" required>
                        </div>
                        <div class="mb-3">
                            <label for="taskDescription" class="form-label">Descrição</label>
                            <textarea class="form-control" id="taskDescription" name = "taskDescription" rows="3" required></textarea>
                        </div>              
                        <div class="mb-3">
                            <label for="taskStatus" class="form-label">Status</label>
                            <select class="form-select" id="taskStatus" name="taskStatus" required>
                                <option value="incompleta" selected >Incompleta</option>
                                <option value="completa">Completa</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Salvar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    
    <!-- Modal de Edição de Tarefa -->
    <div class="modal fade" id="editTaskModal" tabindex="-1" aria-labelledby="editTaskModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editTaskModalLabel">Editar Tarefa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form method = "POST" action = "editarTarefa.php">
                        <div class="mb-3">
                            <label for="editTaskName" class="form-label">Nome da Tarefa</label>
                            <input type="text" class="form-control" id="editTaskName" name="editTaskName" value="Tarefa Exemplo" required>
                        </div>
                        <div class="mb-3">
                            <label for="editTaskDescription" class="form-label">Descrição</label>
                            <textarea class="form-control" id="editTaskDescription" name="editTaskDescription" rows="3" required>Descrição da tarefa</textarea>
                        </div>
                        <div class="mb-3">
                            <label for="editTaskStatus" class="form-label">Status</label>
                            <select class="form-select" id="editTaskStatus" name="editTaskStatus" required>
                                <option value="incompleta">Incompleta</option>
                                <option value="completa" selected>Completa</option>
                            </select>
                            <input type="text" name="idTarefaEdit" id="idTarefaEdit" style='visibility:hidden'>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Salvar Alterações</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    
    <!-- Modal de Confirmação de Exclusão -->
    <div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmDeleteModalLabel">Confirmação de Exclusão</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Tem certeza de que deseja excluir esta tarefa?
                </div>
                <div class="modal-footer">
                    <form action="excluirTarefa.php" method="POST">
                        <input type="text" name="idTarefaExcluir" id="idTarefaExcluir" style='visibility:hidden'>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <input type="submit" value="Excluir" class="btn btn-danger">
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
