package br.edu.ifsp.hto.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// TODO(15) Essa classe representa o banco de dados.
@Database(
    entities = [TaskEntity::class],
    version = 1
)
abstract class TaskDatabaseProvider : RoomDatabase() {
    // TODO(16) Note que o TaskDAO é colocado como um atributo desta classe.
    abstract fun taskDAO(): TaskDAO

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabaseProvider? = null

        fun provide(context: Context): TaskDatabaseProvider {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabaseProvider::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}