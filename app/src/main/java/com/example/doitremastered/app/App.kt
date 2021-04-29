package com.example.doitremastered.app

import android.app.Application
import com.example.doitremastered.AppComponent
import com.example.doitremastered.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {

        appComponent = DaggerAppComponent.factory().create(this)
    }

//    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}