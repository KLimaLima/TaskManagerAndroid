package com.lima.taskmanagerandroid.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val title: String,
    val content: String,
    val isFinished: Boolean
)
