package com.example.doitremastered

import android.content.Context
import com.example.doitremastered.di.ActivitySubComponent
import com.example.doitremastered.di.RepositoryModule
import com.example.doitremastered.di.viewmodeiInjector.ViewModelFactoryModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataBaseModule::class, RepositoryModule::class, ViewModelFactoryModel::class])
interface AppComponent {

    fun activitySubComponent(): ActivitySubComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    companion object {
        fun create(context: Context): AppComponent = DaggerAppComponent.factory().create(context)
    }

}