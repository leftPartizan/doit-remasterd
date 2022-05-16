package com.example.doitremastered.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object NavigationModule {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create(Router()) }

    @Singleton
    @Provides
    fun provideRouter() : Router = cicerone.router

    @Singleton
    @Provides
    fun provideNavigationHolder() : NavigatorHolder = cicerone.getNavigatorHolder()
}