package ua.raylyan.cleanarch.dependency.resolver.component

import dagger.Component
import dagger.android.AndroidInjector
import ua.raylyan.cleanarch.dependency.resolver.CleanApplication
import ua.raylyan.cleanarch.dependency.resolver.module.*
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
