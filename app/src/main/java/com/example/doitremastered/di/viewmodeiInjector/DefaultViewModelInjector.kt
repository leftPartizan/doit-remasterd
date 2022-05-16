package com.example.doitremastered.di.viewmodeiInjector

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class DefaultViewModelInjector<T : Fragment> @Inject constructor(val fragment: T) {
    inline fun <reified R : ViewModel> getViewModel(provider: Provider<R>): R {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return modelClass.cast(provider.get())?.takeIf {
                    modelClass.isAssignableFrom(R::class.java)
                } ?: throw IllegalStateException()
            }
        }
        return ViewModelProvider(fragment.viewModelStore, factory).get(R::class.java)
    }
}