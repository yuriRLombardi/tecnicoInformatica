package br.edu.ifsp.hto.projeto01classe.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoa")
data class PessoaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String,
    val peso: Double,
    val altura: Double
)
