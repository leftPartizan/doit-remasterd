package com.example.doitremastered.domain.useCases

import com.example.doitremastered.domain.entities.CategoryMain
import com.example.doitremastered.domain.repositories.CategoriesRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainCategoriesUseCaseImpl @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) : MainCategoriesUseCase {

    override fun getAllMainCategories(): Single<List<CategoryMain>> {
        return categoriesRepository.getAllCategories()
            .subscribeOn(Schedulers.io())
    }
}