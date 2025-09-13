package br.edu.ifsp.hto.myapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// TODO(11) Definir a Interface TaskDAO com a anotação @Dao. Cada método representa uma operação nos
//  dados da tabela. Os códigos correspondentes à inserção, remoção e listagem são gerados
//  automaticamente pelo Room.
@Dao
interface TaskDAO {
    // TODO(12) Definir o método insert que recebe uma TaskEntity. A anotação @Insert indica que
    //  inserção. O suspend indica que o método será executado de maneria assíncrona.
    // Já o onConflict = OnConflictStrategy.REPLACE indica que se a Task já existir no Banco de
    // Dados é feita uma atualização ao invés de uma nova inserção.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(taskEntity: TaskEntity)

    // TODO(13) Definir o método delete que recebe uma TaskEntity. A anotação @Delete indica que
    //  será feita uma remoção.
    @Delete
    suspend fun delete(taskEntity: TaskEntity)

    // TODO(14) A anotação @Query indica uma consulta. Este método não precisa de suspend, pois é
    //  utilizado um Flow.
    @Query("SELECT * FROM task")
    fun getAll(): Flow<List<TaskEntity>>

    // TODO(15) A anotação @Query indica uma consulta. Este método precisa de suspend, pois ele não
    //  retorna um flow. Além disso o retorno é TaskEntity?, pois a Task pode não existir no banco
    //  para o id passado;
    @Query("SELECT * FROM task WHERE id = :id")
    suspend fun getById(id: Long): TaskEntity?
}