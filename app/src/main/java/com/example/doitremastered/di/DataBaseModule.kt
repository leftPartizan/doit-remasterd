package com.example.doitremastered.di

import android.content.Context
import com.example.doitremastered.data.database.DoItDataBase
import com.example.doitremastered.data.database.categories.dao.CategoriesDao
import com.example.doitremastered.data.database.tasks.TasksDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideTasksDao(context: Context): TasksDao {
        return DoItDataBase.getInstance(context).getTasksDao()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(context: Context): CategoriesDao {
        return DoItDataBase.getInstance(context).getCategoriesDao()
    }
}