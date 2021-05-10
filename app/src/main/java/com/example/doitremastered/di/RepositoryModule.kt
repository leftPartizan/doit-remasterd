package com.example.doitremastered.di

import com.example.doitremastered.data.repositories.Repository
import com.example.doitremastered.data.repositories.RepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindRepo(repository: RepositoryImpl): Repository
}