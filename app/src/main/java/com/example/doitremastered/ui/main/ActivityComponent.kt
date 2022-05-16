package com.example.doitremastered.ui.main

import com.example.doitremastered.di.AppComponent
import com.example.doitremastered.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [AppComponent::class])
@ActivityScope
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun dep(deps: AppComponent): Builder

        @BindsInstance
        fun activity(activity: MainActivity): Builder
        fun create(): ActivityComponent
    }

    companion object {
        fun create(activity: MainActivity, deps: AppComponent) : ActivityComponent {
            return DaggerActivityComponent.builder().dep(deps).activity(activity).create()
        }
    }
}