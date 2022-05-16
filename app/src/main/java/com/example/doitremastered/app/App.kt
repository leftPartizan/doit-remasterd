package com.example.doitremastered.app

import android.app.Application
import com.example.doitremastered.di.AppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {
        appComponent = AppComponent.create(this)
    }
}