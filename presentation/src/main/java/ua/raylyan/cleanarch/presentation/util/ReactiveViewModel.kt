package ua.raylyan.cleanarch.presentation.util

import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class ReactiveViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCleared() = compositeDisposable.clear()

    protected fun ReactiveViewModel.disposable(): Lazy<CompositeDisposable> =
            lazy { CompositeDisposable() }

    protected fun <T> ReactiveViewModel.liveData(): Lazy<LiveData<T>> =
            lazy { MutableLiveData<T>() }

    protected fun <T> ReactiveViewModel.liveData(initialValue: T): Lazy<LiveData<T>> =
            lazy { MutableLiveData<T>().apply { value = initialValue } }

    protected fun <T> ReactiveViewModel.singleLiveEvent(): Lazy<LiveData<T>> =
            lazy { SingleLiveEvent<T>() }

    protected fun <T> ReactiveViewModel.singleLiveEvent(initialValue: T): Lazy<LiveData<T>> =
            lazy { SingleLiveEvent<T>().apply { value = initialValue } }

    @MainThread
    protected fun <T> LiveData<T>.update(value: T) {
        (this as? MutableLiveData)?.value = value
    }

    @get:MainThread
    protected val <T> LiveData<T>.updater: (value: T) -> Unit
        get() = { value -> update(value) }

    @MainThread
    protected fun LiveData<Unit>.call() = this.update(Unit)

    @get:MainThread
    protected val LiveData<Unit>.caller: (value: Any) -> Unit
        get() = { call() }
}