package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Completable

interface UpdateCommentsUseCase {
    operator fun invoke(postId: Long): Completable
}