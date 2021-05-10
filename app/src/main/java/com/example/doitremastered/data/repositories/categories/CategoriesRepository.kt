package com.example.doitremastered.data.repositories.categories

import com.example.doitremastered.data.database.categories.entities.CategoryEntity
import io.reactivex.rxjava3.core.Single


interface CategoriesRepository {

    fun getAllCategory(): List<CategoryEntity>
    fun updateCategory(category: CategoryEntity)
    fun findCategoryByName(name: String): CategoryEntity
    fun getAllCategories(): Single<List<CategoryEntity>>
    fun delete(category: CategoryEntity)
}