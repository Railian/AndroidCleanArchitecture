package ua.raylyan.cleanarch.presentation.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel


interface CustomView<T : ViewModel> {
    fun initView(owner: LifecycleOwner, viewModel: T)
}