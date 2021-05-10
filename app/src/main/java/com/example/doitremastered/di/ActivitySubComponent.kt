package com.example.doitremastered.di

import android.app.Activity
import com.example.doitremastered.MainActivity
import com.example.doitremastered.ViewModelModule
import com.example.doitremastered.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ViewModelModule::class])
interface ActivitySubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: Activity): ActivitySubComponent
    }
}