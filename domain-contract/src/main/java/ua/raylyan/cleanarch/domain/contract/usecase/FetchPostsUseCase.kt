package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Completable

interface FetchPostsUseCase {
    operator fun invoke():Completable
}