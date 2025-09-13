package br.edu.ifsp.hto.projeto01classe.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PessoaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pessoaEntity: PessoaEntity)
    @Delete
    suspend fun delete(pessoaEntity: PessoaEntity)
    @Query("SELECT * FROM pessoa")
    fun getAllPessoa(): Flow<List<PessoaEntity>>
    @Query("SELECT * FROM pessoa WHERE id = :id")
    suspend fun getPessoaById(id: Long): PessoaEntity?
}