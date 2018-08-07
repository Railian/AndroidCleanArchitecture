package ua.raylyan.cleanarch.presentation.util

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.android.*
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import dagger.multibindings.Multibinds
import javax.inject.Inject


abstract class DaggerxAppCompatActivity : AppCompatActivity(), HasFragmentInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    override fun supportFragmentInjector() = supportFragmentInjector

    override fun fragmentInjector() = frameworkFragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}


abstract class DaggerxFragment : Fragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = childFragmentInjector

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}


abstract class DaggerxApplication : dagger.android.DaggerApplication(), HasSupportFragmentInjector {

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = supportFragmentInjector

    abstract override fun applicationInjector(): AndroidInjector<out DaggerxApplication>
}


@Module(includes = [AndroidInjectionModule::class])
abstract class AndroidxSupportInjectionModule {

    @Multibinds
    abstract fun supportFragmentInjectorFactories(): Map<Class<out Fragment>, AndroidInjector.Factory<out Fragment>>
}