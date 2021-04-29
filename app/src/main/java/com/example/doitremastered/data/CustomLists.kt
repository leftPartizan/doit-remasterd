package com.example.doit.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "custom_lists")
data class CustomLists(
    @ColumnInfo(name = "title_item")
    var title: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
