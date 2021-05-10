package com.example.doitremastered.data.database.tasks

import androidx.room.TypeConverter
import java.util.*

object TasksConverters {
    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: Long?): Calendar? = value?.let {
        GregorianCalendar().also { calendar ->
            calendar.timeInMillis = value
        }
    }

    @TypeConverter
    @JvmStatic
    fun toTimestamp(timestamp: Calendar?): Long? = timestamp?.timeInMillis
}