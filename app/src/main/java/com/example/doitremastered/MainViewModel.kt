package com.example.doitremastered

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.doitremastered.data.repositories.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
    }

    fun printLog() = Log.d("www", "hello from viwmodel")

    suspend fun getAllListTasks() = repository.getAllList()
}