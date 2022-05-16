package com.example.doitremastered.data.repositories.categories

import com.example.doitremastered.data.database.categories.dao.CategoriesDao
import com.example.doitremastered.data.mapper.CategoriesMapper
import com.example.doitremastered.domain.entities.CategoryMain
import com.example.doitremastered.domain.repositories.CategoriesRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoriesDao: CategoriesDao,
    private val mapper: CategoriesMapper
) : CategoriesRepository {

    override fun getAllCategories(): Single<List<CategoryMain>> {
        return categoriesDao.getAllCategories().map { it.map(mapper::mapDtoToDomain) }
    }

    override fun updateCategory(categoryMain: CategoryMain) {
        // NOOP
    }

    override fun findCategoryByName(name: String): Single<CategoryMain> {
        return Single.never()
    }

    override fun delete(categoryMain: CategoryMain) {
        // NOOP
    }
}