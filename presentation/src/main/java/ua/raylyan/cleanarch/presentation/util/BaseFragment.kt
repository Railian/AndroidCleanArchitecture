package ua.raylyan.cleanarch.presentation.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

open class BaseFragment : DaggerxFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified T : ViewModel> BaseFragment.getViewModelOf(
            activity: FragmentActivity,
            key: String? = null
    ): T {
        val provider = ViewModelProviders.of(activity, viewModelFactory)
        return key?.let { provider.get(it, T::class.java) } ?: provider[T::class.java]
    }

    inline fun <reified T : ViewModel> BaseFragment.getViewModelOf(
            fragment: Fragment,
            key: String? = null
    ): T {
        val provider = ViewModelProviders.of(fragment, viewModelFactory)
        return key?.let { provider.get(it, T::class.java) } ?: provider[T::class.java]
    }

    inline fun <reified T : ViewModel> BaseFragment.getViewModel(
            key: String? = null
    ): T = getViewModelOf(this, key)

    inline fun <reified T : ViewModel> BaseFragment.viewModelProviderOf(
            activity: FragmentActivity,
            key: String? = null
    ): Lazy<T> =
            lazy { getViewModelOf<T>(activity, key) }

    inline fun <reified T : ViewModel> BaseFragment.viewModelProviderOf(
            fragment: Fragment,
            key: String? = null
    ): Lazy<T> =
            lazy { getViewModelOf<T>(fragment, key) }

    inline fun <reified T : ViewModel> BaseFragment.viewModelProvider(
            key: String? = null
    ): Lazy<T> =
            lazy { getViewModel<T>() }
}