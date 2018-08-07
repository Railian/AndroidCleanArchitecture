package ua.raylyan.cleanarch.dependency.injection.component

import dagger.Component
import dagger.android.AndroidInjector
import ua.raylyan.cleanarch.dependency.injection.CleanApplication
import ua.raylyan.cleanarch.dependency.injection.module.*
import javax.inject.Singleton


@Component(modules = [
    DataSourceModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    ViewModule::class
])
@Singleton
interface AppComponent : AndroidInjector<CleanApplication>
