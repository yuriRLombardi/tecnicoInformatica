package br.edu.ifsp.hto.projeto01classe.data

import br.edu.ifsp.hto.projeto01classe.domain.Pessoa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class PessoaRepositoryImpl(
    val daoRoom: PessoaDAO
): PessoaRepository{
    override suspend fun insert(
        id: Long?,
        nome: String,
        peso: Double,
        altura: Double
    ) {
        if (id == null){
            val pessoaEntity = PessoaEntity(
                nome = nome,
                peso = peso,
                altura = altura
            )
            daoRoom.insert(pessoaEntity)
        }
        else{
            val pessoaEntity = daoRoom.getPessoaById(id)
            if (pessoaEntity != null){
                val updateEntity = pessoaEntity.copy(
                    nome = nome,
                    peso = peso,
                    altura = altura
                )
                daoRoom.insert(updateEntity)
            }
        }
    }

    override suspend fun delete(id: Long) {
        val exitingEntity = daoRoom.getPessoaById(id) ?: return
        daoRoom.delete(exitingEntity)
    }

    override fun getAllPessoa(): Flow<List<Pessoa>> {
        return daoRoom.getAllPessoa().map{ pessoaEntities : List<PessoaEntity> ->
                pessoaEntities.map { pessoaEntity : PessoaEntity ->
                        Pessoa(
                            id = pessoaEntity.id,
                            nome = pessoaEntity.nome,
                            peso = pessoaEntity.peso,
                            altura = pessoaEntity.altura,
                        )
                }
            }
        }


    override suspend fun getPessoaById(id: Long): Pessoa? {
        val existingEntity = daoRoom.getPessoaById(id)
        if (existingEntity != null){
            return Pessoa(
                id = existingEntity.id,
                nome = existingEntity.nome,
                peso = existingEntity.peso,
                altura = existingEntity.altura
            )
        }
        return null
    }

}