package com.example.doitremastered.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import arrow.core.Either
import com.example.doitremastered.contracts.BaseViewModel
import com.example.doitremastered.domain.entities.CategoryMain
import com.example.doitremastered.domain.useCases.MainCategoriesUseCase
import com.example.doitremastered.navigation.Screens
import javax.inject.Inject

class MainViewModelImpl @Inject constructor(
    private val mainCategoriesUseCase: MainCategoriesUseCase,
) : BaseViewModel(), MainViewModel {

    override val mainCategories: MutableLiveData<List<CategoryMain>> = MutableLiveData(emptyList())

    private fun getAllMainCategories() {
        Either
        mainCategoriesUseCase.getAllMainCategories()
            .subscribeIn(onSuccess = mainCategories::postValue)
    }

    override fun start() {
        getAllMainCategories()
    }

    override fun goToCategory(name: String) {
        router.navigateTo(Screens.mainCategory(name))
    }
}