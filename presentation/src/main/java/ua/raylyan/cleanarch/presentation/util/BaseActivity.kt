package ua.raylyan.cleanarch.presentation.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject


open class BaseActivity : DaggerxAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified T : ViewModel> BaseActivity.getViewModelOf(activity: FragmentActivity): T {
        return ViewModelProviders.of(activity, viewModelFactory)[T::class.java]
    }

    inline fun <reified T : ViewModel> BaseActivity.getViewModelOf(fragment: Fragment): T {
        return ViewModelProviders.of(fragment, viewModelFactory)[T::class.java]
    }

    inline fun <reified T : ViewModel> BaseActivity.getViewModel(): T {
        return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    }

    inline fun <reified T : ViewModel> BaseActivity.viewModelProviderOf(activity: FragmentActivity): Lazy<T> =
            lazy { getViewModelOf<T>(activity) }

    inline fun <reified T : ViewModel> BaseActivity.viewModelProviderOf(fragment: Fragment): Lazy<T> =
            lazy { getViewModelOf<T>(fragment) }

    inline fun <reified T : ViewModel> BaseActivity.viewModelProvider(): Lazy<T> =
            lazy { getViewModel<T>() }
}