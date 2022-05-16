package com.example.doitremastered.domain.entities

import androidx.recyclerview.widget.DiffUtil
import com.example.doitremastered.data.database.categories.entities.CategoryEntity

data class CategoryMain(
    val id: Long?,
    val name: String,
    val isPrimary: Boolean = false
) {
    companion object Diff : DiffUtil.ItemCallback<CategoryMain>() {
        override fun areItemsTheSame(oldItem: CategoryMain, newItem: CategoryMain): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryMain, newItem: CategoryMain): Boolean {
            return oldItem == newItem
        }
    }
}

fun CategoryMain.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
        isPrimary = isPrimary
    )
}