package br.edu.ifsp.hto.projeto01classe.data

import br.edu.ifsp.hto.projeto01classe.domain.Pessoa

class PessoaDAOImpli : PessoaDAO {
    private val pessoas = PessoaDataSource.pessoas
    override fun insert(pessoa: Pessoa) {
        pessoas.add(pessoa.copy(id = PessoaDataSource.currentID++))
    }

    override fun delete(pessoa: Pessoa) {
        val pessoaToRemove = getPessoaById(pessoa.id)
        if (pessoaToRemove != null) {
            pessoas.remove(pessoaToRemove)
        }
    }

    override fun uptade(pessoa: Pessoa) {
        val index = pessoas.indexOfFirst { it.id == pessoa.id }
        if (index != -1) {
            pessoas[index] = pessoa
        }
    }

    override fun getAllPessoa(): List<Pessoa> {
        return pessoas
    }

    override fun getPessoaById(id: Long): Pessoa? {
        val index = pessoas.indexOfFirst { it.id == id }
        if (index != -1) {
            return pessoas[index]
        }
        return null
    }

}

