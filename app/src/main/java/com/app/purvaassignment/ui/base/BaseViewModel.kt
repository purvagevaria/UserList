package com.app.purvaassignment.ui.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N>(application: Application) : AndroidViewModel(application) {
    var disposable = CompositeDisposable()
    private val mIsLoading: ObservableBoolean = ObservableBoolean(false)


    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mNavigator: N? = null


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

    fun getNavigator(): N? {
        return mNavigator
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = navigator
    }


}