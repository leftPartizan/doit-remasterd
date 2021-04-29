package com.example.doitremastered

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel : ViewModel() {

    public fun printLog() = Log.d("www", "hello from viewmodel")
}