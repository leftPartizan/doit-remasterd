package com.example.doitremastered.di

import android.content.Context
import com.example.doitremastered.domain.repositories.CategoriesRepository
import com.example.doitremastered.navigation.NavigationModule
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataBaseModule::class,
    RepositoryModule::class,
    NavigationModule::class
])
interface AppComponent {

    val categoriesRepository : CategoriesRepository

    val router: Router

    val navigatorHolder: NavigatorHolder

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    companion object {
        fun create(context: Context): AppComponent = DaggerAppComponent.factory().create(context)
    }
}