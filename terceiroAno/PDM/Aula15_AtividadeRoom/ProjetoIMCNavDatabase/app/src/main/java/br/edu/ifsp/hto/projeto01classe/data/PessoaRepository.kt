package br.edu.ifsp.hto.projeto01classe.data

import br.edu.ifsp.hto.projeto01classe.domain.Pessoa
import kotlinx.coroutines.flow.Flow

interface PessoaRepository {
    suspend fun insert(id:Long?, nome:String, peso:Double, altura:Double)

    suspend fun delete(id: Long)

    fun getAllPessoa(): Flow<List<Pessoa>>

    suspend fun getPessoaById(id: Long): Pessoa?
}