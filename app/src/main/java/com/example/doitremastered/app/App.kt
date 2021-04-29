package com.example.doitremastered.app

import android.app.Application
import com.example.doitremastered.AppComponent

class App : Application() {

    lateinit var appCompact : AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {

//        appCompact = DaggerAppComponent.factory()
    }

//    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}