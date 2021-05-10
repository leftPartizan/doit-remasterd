package com.example.doitremastered.data.database.tasks

import androidx.room.*

@Dao
interface TasksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(taskEntity: TaskEntity): Long

    @Query("SELECT * FROM tasks")
    fun getAllItems(): List<TaskEntity>

    @Query("SELECT * FROM tasks where category = :category")
    fun getAllTasksByCategory(category: String): List<TaskEntity>

    @Query("SELECT * FROM tasks WHERE id = :tmpId")
    suspend fun findTaskById(tmpId: Long): TaskEntity

    @Query("UPDATE tasks SET requestId = :requestId WHERE id = :tmpId")
    suspend fun updateRequestId(tmpId: Long, requestId: String)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)

    @Query("SELECT * FROM tasks where notification_time not null")
    fun getAllTasksPlanned(): List<TaskEntity>

    @Query("SELECT * FROM tasks where repeat_mode is not 'NEVER_REPEAT' ")
    fun getAllTasksRepeatable(): List<TaskEntity>

    @Query("UPDATE tasks SET favorite = :state WHERE id = :tmpId")
    suspend fun updateTaskFavorite(tmpId: Int, state: Boolean)

}