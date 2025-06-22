package br.edu.ifsp.hto.projeto01classe.data

import br.edu.ifsp.hto.projeto01classe.domain.Pessoa

interface PessoaDAO {
    fun insert(pessoa: Pessoa)
    fun delete(pessoa: Pessoa)
    fun uptade(pessoa: Pessoa)
    fun getAllPessoa(): List<Pessoa>
    fun getPessoaById(id: Long): Pessoa?
}