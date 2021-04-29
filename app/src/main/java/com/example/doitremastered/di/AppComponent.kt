package com.example.doitremastered

import android.app.Activity
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, DataBaseModule::class])
interface AppComponent {

    fun injectActivity(mainActivity: Activity)
//    override fun inject(instance: App)
//
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application : Application) : AppComponent
    }
}