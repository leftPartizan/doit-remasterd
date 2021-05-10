package com.example.doitremastered.data.repositories

import com.example.doit.data.db.entities.CustomLists

interface Repository {

    suspend fun getAllList(): List<CustomLists>
}