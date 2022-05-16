package com.example.doitremastered.data.database.categories.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.doitremastered.domain.entities.CategoryMain

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "is_primary")
    val isPrimary: Boolean = false
)

fun CategoryEntity.toMainCategory(): CategoryMain {
    return CategoryMain(
        id = id,
        name = name,
        isPrimary = isPrimary
    )
}