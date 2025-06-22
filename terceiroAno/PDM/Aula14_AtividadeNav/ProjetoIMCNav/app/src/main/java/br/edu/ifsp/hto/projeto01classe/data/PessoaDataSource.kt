package br.edu.ifsp.hto.projeto01classe.data

import androidx.compose.runtime.mutableStateListOf
import br.edu.ifsp.hto.projeto01classe.domain.Pessoa

object PessoaDataSource {
    val pessoas = mutableStateListOf<Pessoa>()
    var currentID: Long = 0
}