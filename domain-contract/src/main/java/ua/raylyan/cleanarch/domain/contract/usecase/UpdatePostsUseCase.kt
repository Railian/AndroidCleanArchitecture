package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Completable

interface UpdatePostsUseCase {
    operator fun invoke():Completable
}