package com.example.doitremastered

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doitremastered.app.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideVM(mainActivity: MainActivity) : MainViewModel =
        ViewModelProvider(mainActivity).get(MainViewModel::class.java)

//    @Provides
//    @Singleton
//    fun provideVM() : MainViewModel =  MainViewModel()

}