package com.example.doitremastered

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {


    @Provides
    @Singleton
    fun provideDoItDao(context: Context): DoItDao {
        return DoItDataBase.getInstance(context).getDoItDao()
    }

    @Provides
    fun provideCustomListsDao(context: Context): CustomListsDao {
        return DoItDataBase.getInstance(context).getCustomListDao()
    }

}