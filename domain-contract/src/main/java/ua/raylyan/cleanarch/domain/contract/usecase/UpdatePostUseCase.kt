package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Completable

interface UpdatePostUseCase {
    operator fun invoke(postId: Long): Completable
}