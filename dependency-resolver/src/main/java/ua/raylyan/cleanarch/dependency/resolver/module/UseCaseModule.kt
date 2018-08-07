package ua.raylyan.cleanarch.dependency.resolver.module

import dagger.Binds
import dagger.Module
import ua.raylyan.cleanarch.domain.contract.usecase.*
import ua.raylyan.cleanarch.domain.logic.usecase.*
import javax.inject.Singleton


@Module
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindObservePostsUseCase(useCase: ObservePostsUseCaseImpl): ObservePostsUseCase

    @Binds
    @Singleton
    abstract fun bindObservePostUseCase(useCase: ObservePostUseCaseImpl): ObservePostUseCase

    @Binds
    @Singleton
    abstract fun bindObserveCommentsUseCase(useCase: ObserveCommentsUseCaseImpl): ObserveCommentsUseCase

    @Binds
    @Singleton
    abstract fun bindUpdatePostsUseCase(useCase: UpdatePostsUseCaseImpl): UpdatePostsUseCase

    @Binds
    @Singleton
    abstract fun bindUpdatePostUseCase(useCase: UpdatePostUseCaseImpl): UpdatePostUseCase

    @Binds
    @Singleton
    abstract fun bindUpdateCommentsUseCase(useCase: UpdateCommentsUseCaseImpl): UpdateCommentsUseCase
}