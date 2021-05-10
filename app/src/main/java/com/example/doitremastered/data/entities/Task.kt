package com.example.doitremastered.data.entities

import com.example.doitremastered.data.database.tasks.TaskEntity
import java.util.*

data class Task(
    var id: Long? = null,
    var name: String,
    var category: String,
    var requestId: String? = null,
    var favorite: Boolean = false,
    var notificationTime: Calendar? = null,
    var repeat_mode: String = "AddItemDialog.NEVER_REPEAT",
)

fun Task.toTaskEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        name = name,
        category = category,
        requestId = requestId,
        favorite = favorite,
        notificationTime = notificationTime,
        repeat_mode = repeat_mode
    )
}

fun TaskEntity.toTask(): Task {
    return Task(
        id = id,
        name = name,
        category = category,
        requestId = requestId,
        favorite = favorite,
        notificationTime = notificationTime,
        repeat_mode = repeat_mode
    )
}