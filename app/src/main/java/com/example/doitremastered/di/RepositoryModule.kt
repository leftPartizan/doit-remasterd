package com.example.doitremastered.di

import com.example.doitremastered.data.repositories.categories.CategoriesRepositoryImpl
import com.example.doitremastered.data.repositories.tasks.TasksRepository
import com.example.doitremastered.data.repositories.tasks.TasksRepositoryImpl
import com.example.doitremastered.domain.repositories.CategoriesRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindTasksRepository(repository: TasksRepositoryImpl): TasksRepository

    @Binds
    @Singleton
    fun bindCategoriesRepository(repository: CategoriesRepositoryImpl): CategoriesRepository
}