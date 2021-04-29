package com.example.doitremastered

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.doit.data.db.entities.CustomLists
import com.example.doit.data.db.entities.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@TypeConverters(Converters::class)
@Database(
    entities = [Item::class, CustomLists::class],
    version = 8, exportSchema = false
)
abstract class DoItDataBase : RoomDatabase() {
    abstract fun getDoItDao(): DoItDao
    abstract fun getCustomListDao(): CustomListsDao

    private class DoItDatabaseCallback(
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            instance?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
//                    var customListDao = database.getCustomListDao()

//                    customListDao.insertList(CustomLists("My Day"))
//                    customListDao.insertList(CustomLists("Tasks"))
//                    customListDao.insertList(CustomLists("Favorites"))
//                    customListDao.insertList(CustomLists("Repeatable"))
//                    customListDao.insertList(CustomLists("Planned"))
//
//                    customListDao.insertList(CustomLists("Мой день"))
//                    customListDao.insertList(CustomLists("Задачи"))
//                    customListDao.insertList(CustomLists("Избранные"))
//                    customListDao.insertList(CustomLists("Повторяющиеся"))
//                    customListDao.insertList(CustomLists("Запланировано"))
                }
            }
        }
    }

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
            )
                .addCallback(DoItDatabaseCallback())
                .fallbackToDestructiveMigration()
                .build()
    }
}