package br.edu.ifsp.hto.lista_tarefas.data.remote

import br.edu.ifsp.hto.lista_tarefas.domain.Task
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskService {
    @GET("tasks")
    suspend fun getAll(): List<Task>

    @GET("task/{id}")
    suspend fun getById(@Path("id") id: Long): Task

    @POST("task")
    suspend fun create(@Body task: Task)

    @PUT("task/{id}")
    suspend fun update(@Path("id") id: Long, @Body task: Task)

    @DELETE("task/{id}")
    suspend fun deleteTask(@Path("id") id: Long)
}