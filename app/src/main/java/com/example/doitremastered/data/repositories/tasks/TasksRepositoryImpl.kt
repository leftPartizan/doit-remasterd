package com.example.doitremastered.data.repositories.tasks

import com.example.doitremastered.data.database.categories.dao.CategoriesDao
import com.example.doitremastered.data.database.categories.entities.CategoryEntity
import com.example.doitremastered.data.database.tasks.TasksDao
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    val tasksDao: TasksDao,
    val daoList: CategoriesDao
) : TasksRepository {
    override fun getAllList(): List<CategoryEntity> {
        TODO("Not yet implemented")
    }

}