package com.example.doitremastered.ui.main.di

import com.example.doitremastered.di.AppComponent
import com.example.doitremastered.di.scope.FragmentScope
import com.example.doitremastered.di.viewmodeiInjector.DefaultViewModelInjector
import com.example.doitremastered.domain.useCases.MainCategoriesUseCaseImpl
import com.example.doitremastered.domain.useCases.MainCategoriesUseCase
import com.example.doitremastered.ui.main.view.MainFragment
import com.example.doitremastered.ui.main.viewmodel.MainViewModel
import com.example.doitremastered.ui.main.viewmodel.MainViewModelImpl
import dagger.*
import javax.inject.Provider

@FragmentScope
@Component(modules = [MainScreenModule::class], dependencies = [AppComponent::class])
interface MainScreenComponent {

    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        fun dep(deps: AppComponent): Builder

        @BindsInstance
        fun fragment(fragment: MainFragment): Builder
        fun create(): MainScreenComponent
    }

    companion object {
        fun create(fragment: MainFragment, deps: AppComponent): MainScreenComponent {
            return DaggerMainScreenComponent.builder().dep(deps).fragment(fragment).create()
        }
    }
}

@Module
interface MainScreenModule {

    companion object {
        @FragmentScope
        @Provides
        fun provideViewModel(
            provider: Provider<MainViewModelImpl>,
            fragment: MainFragment
        ): MainViewModel = DefaultViewModelInjector(fragment).getViewModel(provider)
    }

    @Binds
    @FragmentScope
    fun bindUseCase(useCase: MainCategoriesUseCaseImpl): MainCategoriesUseCase
}