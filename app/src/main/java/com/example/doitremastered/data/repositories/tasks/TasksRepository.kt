package com.example.doitremastered.data.repositories.tasks

import com.example.doitremastered.data.database.categories.entities.CategoryEntity


interface TasksRepository {

    fun getAllList(): List<CategoryEntity>
}