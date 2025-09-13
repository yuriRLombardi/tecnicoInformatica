package br.edu.ifsp.hto.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO(9) Definir uma data class que representa um registro de Task. Utilizar a anotação @Entity
//  para indicar ao Room que se trata de uma tabela.
@Entity(tableName = "task")
data class TaskEntity(
    // TODO(10) Marcar o atributo id com a anotação @PrimaryKey, indicando que é uma chave primária.
    //  Além disso o id é gerado automaticamente com o autoGenerate = True.
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val isFinished: Boolean
)