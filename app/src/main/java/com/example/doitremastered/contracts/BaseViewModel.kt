package com.example.doitremastered.contracts

import androidx.lifecycle.ViewModel
import com.example.doitremastered.utils.addTo
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

abstract class BaseViewModel : ViewModel(), IViewModel {

    @Inject
    lateinit var router: Router

    private val compositeDisposable = CompositeDisposable()

    protected fun <T: Any> Single<T>.subscribeIn(
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit = Timber::d
    ) {
        subscribe(onSuccess, onError).addTo(compositeDisposable)
    }

    override fun onBack() {
        router.exit()
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}