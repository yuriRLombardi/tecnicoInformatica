package br.edu.ifsp.hto.myapplication.data

import br.edu.ifsp.hto.myapplication.domain.Task
import kotlinx.coroutines.flow.Flow

// TODO(17) Essa interface é necessária, pois desejamos expor a classe Task para o código e não
//  TaskEntity. Isso é necessário para desacoplar o restante do código de TaskEntity que é uma
//  classe específica para uso de Banco de Dados. No futuro, caso queiramos mudar a persistência
//  (armazenamento) dos dados em outro local, usando webservice, por exemplo, basta alterar
//  o repository ao invés do código todo.
interface TaskRepository {

    // TODO(18) Definimos um método para cada operação a ser realizada. Ao invés de receber um
    //  objeto, recebemos cada atributo da classe Task
    suspend fun insert(id: Long?, title: String, description: String?)

    suspend fun delete(id: Long)

    // TODO(19) Note que este método retorna uma Task e não TaskEntity.
    fun getAll(): Flow<List<Task>>

    suspend fun getById(id: Long): Task?

    suspend fun isFinishedChanged(id: Long, isFinished: Boolean)
}