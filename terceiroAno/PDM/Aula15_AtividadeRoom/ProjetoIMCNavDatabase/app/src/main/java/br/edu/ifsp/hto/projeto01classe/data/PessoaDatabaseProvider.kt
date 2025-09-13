package br.edu.ifsp.hto.projeto01classe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [PessoaEntity::class],
    version = 1
)
abstract class PessoaDatabaseProvider : RoomDatabase() {
    abstract fun pessoaDAO() : PessoaDAO

    companion object{
        @Volatile
        private var INSTANCE: PessoaDatabaseProvider? = null
        fun provide(context: Context): PessoaDatabaseProvider{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PessoaDatabaseProvider::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}