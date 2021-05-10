package com.example.doitremastered.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.doitremastered.data.database.categories.dao.CategoriesDao
import com.example.doitremastered.data.database.categories.entities.CategoryEntity
import com.example.doitremastered.data.database.tasks.TaskEntity
import com.example.doitremastered.data.database.tasks.TasksConverters
import com.example.doitremastered.data.database.tasks.TasksDao

@TypeConverters(TasksConverters::class)
@Database(
    entities = [TaskEntity::class, CategoryEntity::class],
    version = 8, exportSchema = false
)
abstract class DoItDataBase : RoomDatabase() {
    abstract fun getTasksDao(): TasksDao
    abstract fun getCategoriesDao(): CategoriesDao

    companion object {
        @Volatile
        private var instance: DoItDataBase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DoItDataBase::class.java,
                "DoItDB.db",
            ).build()
    }
}