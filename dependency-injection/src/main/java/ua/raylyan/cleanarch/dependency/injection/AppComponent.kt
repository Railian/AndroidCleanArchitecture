package ua.raylyan.cleanarch.dependency.injection

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: DaggerApplication)
}