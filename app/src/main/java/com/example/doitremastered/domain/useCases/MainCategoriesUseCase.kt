package com.example.doitremastered.domain.useCases

import com.example.doitremastered.domain.entities.CategoryMain
import io.reactivex.rxjava3.core.Single

interface MainCategoriesUseCase {

    fun getAllMainCategories(): Single<List<CategoryMain>>
}