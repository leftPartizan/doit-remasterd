package com.example.doitremastered

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.doit.data.db.entities.CustomLists
import com.example.doit.data.db.entities.Item

@TypeConverters(Converters::class)
@Database(
    entities = [Item::class, CustomLists::class],
    version = 8, exportSchema = false
)
abstract class DoItDataBase : RoomDatabase() {
    abstract fun getDoItDao(): DoItDao
    abstract fun getCustomListDao(): CustomListsDao

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