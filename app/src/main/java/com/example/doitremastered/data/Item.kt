package com.example.doit.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "items")
data class Item(

    @ColumnInfo(name = "title_item")
    var title: String,

    @ColumnInfo(name = "group_item")
    var group: String,

    @ColumnInfo(name = "notification_time")
    var calendar: Calendar? = null,

    @ColumnInfo(name = "repeat_item")
    var repeate: String = "AddItemDialog.NEVER_REPEAT"

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    @ColumnInfo(name = "requestId_item")
    var requestId: String? = null

    @ColumnInfo(name = "favorite_item")
    var favorite: Boolean = false
}