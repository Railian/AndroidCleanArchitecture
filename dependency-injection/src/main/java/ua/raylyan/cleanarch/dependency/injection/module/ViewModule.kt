package ua.raylyan.cleanarch.dependency.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ua.raylyan.cleanarch.presentation.scene.post.PostActivity
import ua.raylyan.cleanarch.presentation.scene.post.PostFragment
import ua.raylyan.cleanarch.presentation.scene.posts.PostsActivity
import ua.raylyan.cleanarch.presentation.scene.posts.PostsFragment
import ua.raylyan.cleanarch.presentation.util.AndroidxSupportInjectionModule


@Module(includes = [AndroidxSupportInjectionModule::class])
interface ViewModule {

    @ContributesAndroidInjector
    fun postsActivityInjector(): PostsActivity

    @ContributesAndroidInjector
    fun postsFragmentInjector(): PostsFragment

    @ContributesAndroidInjector
    fun postActivityInjector(): PostActivity

    @ContributesAndroidInjector
    fun postFragmentInjector(): PostFragment
}