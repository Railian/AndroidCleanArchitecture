package ua.raylyan.cleanarch.dependency.injection

import dagger.android.AndroidInjector
import ua.raylyan.cleanarch.dependency.injection.component.DaggerAppComponent
import ua.raylyan.cleanarch.presentation.util.DaggerxApplication

class CleanApplication : DaggerxApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerxApplication> = DaggerAppComponent.create()
}