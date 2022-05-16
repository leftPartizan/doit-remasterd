package com.example.doitremastered.ui.main.viewmodel

import androidx.lifecycle.LiveData
import com.example.doitremastered.domain.entities.CategoryMain

interface MainViewModel {
    fun start()
    fun goToCategory(name: String)

    val mainCategories : LiveData<List<CategoryMain>>
}