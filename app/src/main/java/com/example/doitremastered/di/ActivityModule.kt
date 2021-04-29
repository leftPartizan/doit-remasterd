package com.example.doitremastered.di

import com.example.doitremastered.MainActivity
import dagger.Binds
import dagger.Module

@Module
interface ActivityModule {

    @Binds
    fun bindActivity() : MainActivity
}