package com.lima.taskmanagerandroid.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface TaskDao {

    //Create
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTask(task: Task)

    //Read
    @Transaction
    @Query("SELECT * FROM task WHERE _id = :taskId")
    suspend fun getTaskById(taskId: Int): Task

    //Update
    @Update
    suspend fun updateTask(task: Task)

    //Delete
    @Delete
    suspend fun deleteTask(task: Task)

}