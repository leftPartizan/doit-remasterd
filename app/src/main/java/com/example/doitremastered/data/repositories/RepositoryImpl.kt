package com.example.doitremastered.data.repositories

import com.example.doitremastered.CustomListsDao
import com.example.doitremastered.DoItDao
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val dao: DoItDao,
    val daoList: CustomListsDao
) : Repository {

    override suspend fun getAllList() = daoList.getAllLists()

}