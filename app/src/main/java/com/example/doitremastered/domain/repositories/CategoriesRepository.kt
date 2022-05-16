package com.example.doitremastered.domain.repositories

import com.example.doitremastered.domain.entities.CategoryMain
import io.reactivex.rxjava3.core.Single


interface CategoriesRepository {

    fun updateCategory(categoryMain: CategoryMain)
    fun findCategoryByName(name: String): Single<CategoryMain>
    fun getAllCategories(): Single<List<CategoryMain>>
    fun delete(categoryMain: CategoryMain)
}