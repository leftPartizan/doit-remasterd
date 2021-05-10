package com.example.doitremastered

import androidx.lifecycle.ViewModel
import com.example.doitremastered.di.viewmodeiInjector.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindUserViewModel(mainViewModel: MainViewModel): ViewModel

}