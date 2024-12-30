package com.lima.taskmanagerandroid.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    //Create
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTask(task: Task)

    //Read
    @Transaction
    @Query("SELECT * FROM task WHERE _id = :taskId")
    suspend fun getTaskById(taskId: Int): Task

    @Transaction
    @Query("SELECT * FROM task WHERE _id = :taskId")
    fun getTaskByIdFlow(taskId: Int): Flow<Task?>

    @Transaction
    @Query("SELECT * FROM task ORDER BY isFinished DESC")
    fun readAllTasksSortByFavorite(): Flow<List<Task>>

    @Transaction
    @Query("SELECT * FROM task")
    fun readAllTasks(): Flow<List<Task>>

    //Update
    @Update
    suspend fun updateTask(task: Task)

    @Query("UPDATE task SET isFinished = :isFinished WHERE _id = :taskId")
    suspend fun setFinishedTask(isFinished: Boolean, taskId: Int)

    //Delete
    @Delete
    suspend fun deleteTask(task: Task)

}