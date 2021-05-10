package com.example.doitremastered.di

import com.example.doitremastered.data.repositories.tasks.TasksRepository
import com.example.doitremastered.data.repositories.tasks.TasksRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepo(repository: TasksRepositoryImpl): TasksRepository
}