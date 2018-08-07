package ua.raylyan.cleanarch.presentation.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> LifecycleOwner.observe(liveData: LiveData<T>, onChange: (value: T) -> Unit): Observer<T> {
    val observer = Observer { value: T -> onChange(value) }
    liveData.observe(this, observer)
    return observer
}