package com.example.doitremastered.data.database.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "requestId")
    var requestId: String? = null,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,

    @ColumnInfo(name = "notification_time")
    var notificationTime: Calendar? = null,

    @ColumnInfo(name = "repeat_mode")
    var repeat_mode: String = "AddItemDialog.NEVER_REPEAT",
)