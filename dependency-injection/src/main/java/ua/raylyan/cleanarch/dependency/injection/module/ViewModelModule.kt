package ua.raylyan.cleanarch.dependency.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ua.raylyan.cleanarch.dependency.injection.util.ViewModelFactory
import ua.raylyan.cleanarch.dependency.injection.util.ViewModelKey
import ua.raylyan.cleanarch.presentation.scene.post.PostViewModel
import ua.raylyan.cleanarch.presentation.scene.posts.PostsViewModel
import javax.inject.Singleton


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(viewModel: PostViewModel): ViewModel

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}