package com.example.doitremastered.data.entities

import com.example.doitremastered.data.database.categories.entities.CategoryEntity

data class Category(
    val id: Long?,
    val name: String,
) {}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
    )
}

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
    )
}