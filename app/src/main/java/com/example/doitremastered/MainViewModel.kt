package com.example.doitremastered

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.doitremastered.data.repositories.tasks.TasksRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val tasksRepository: TasksRepository
) : ViewModel() {

    init {
    }

    fun printLog() = Log.d("www", "hello from viwmodel")

    fun getAllListTasks() = tasksRepository.getAllList()
}