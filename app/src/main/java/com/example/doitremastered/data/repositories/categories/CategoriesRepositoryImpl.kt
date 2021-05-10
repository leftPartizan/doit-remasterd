package com.example.doitremastered.data.repositories.categories

import com.example.doitremastered.data.database.categories.entities.CategoryEntity
import io.reactivex.rxjava3.core.Single

class CategoriesRepositoryImpl : CategoriesRepository {

    override fun getAllCategory(): List<CategoryEntity> {
        TODO("Not yet implemented")
    }

    override fun updateCategory(category: CategoryEntity) {
        TODO("Not yet implemented")
    }

    override fun findCategoryByName(name: String): CategoryEntity {
        TODO("Not yet implemented")
    }

    override fun getAllCategories(): Single<List<CategoryEntity>> {
        TODO("Not yet implemented")
    }

    override fun delete(category: CategoryEntity) {
        TODO("Not yet implemented")
    }
}