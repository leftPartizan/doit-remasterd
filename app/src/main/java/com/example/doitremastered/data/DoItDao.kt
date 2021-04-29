package com.example.doitremastered

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.doit.data.db.entities.Item
import java.util.*

@Dao
interface DoItDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Item): Long

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>

    @Query("SELECT * FROM items where group_item = :group")
    fun getAllItemsForGroup(group: String): LiveData<List<Item>>

    @Query("SELECT * FROM items WHERE id = :tmpId")
    suspend fun findItemById(tmpId: Long): Item

    @Query("UPDATE items SET requestId_item = :requestId WHERE id = :tmpId")
    suspend fun updateRequestId(tmpId: Long, requestId: String)


    @Update
    suspend fun update(item: Item)
    @Query("SELECT * FROM items where notification_time not null")
    fun getAllItemsPlanned(): LiveData<List<Item>>

    @Query("SELECT * FROM items where repeat_item is not 'NEVER_REPEAT' ")
    fun getAllItemRepeatable(): LiveData<List<Item>>

    @Query("UPDATE items SET favorite_item = :state WHERE id = :tmpId")
    suspend fun updateFavoriteState(tmpId: Int, state: Boolean)

}