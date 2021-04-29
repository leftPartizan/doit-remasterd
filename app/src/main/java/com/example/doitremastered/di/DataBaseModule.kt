package com.example.doitremastered

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDoItDao(application : Application) : DoItDao {
        return DoItDataBase.getInstance(application).getDoItDao()
    }
//
//    @Provides
//    @Singleton
//    fun provideCustomListsDao(context : Context) : CustomListsDao {
//        return DoItDataBase.getInstance(context).getCustomListDao()
//    }

}