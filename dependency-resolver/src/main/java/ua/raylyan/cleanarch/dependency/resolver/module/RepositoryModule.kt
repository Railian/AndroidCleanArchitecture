package ua.raylyan.cleanarch.dependency.resolver.module

import dagger.Binds
import dagger.Module
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.logic.ropository.PostRepositoryImpl
import javax.inject.Singleton


@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPostRepository(repository: PostRepositoryImpl): PostRepository
}