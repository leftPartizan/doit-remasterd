package com.example.doitremastered

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.doit.data.db.entities.CustomLists

@Dao
interface CustomListsDao {
    @Query("SELECT * FROM custom_lists")
    fun getAllLists(): LiveData<List<CustomLists>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: CustomLists)

    @Delete
    suspend fun delete(list: CustomLists)

    @Query("SELECT * FROM custom_lists WHERE title_item = :tmpTitle")
    fun findListByTitle(tmpTitle: String): CustomLists

    @Query("SELECT COUNT(*) FROM custom_lists WHERE title_item = :tmpTitle")
    suspend fun getCountCopy(tmpTitle: String): Int
}