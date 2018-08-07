package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Completable
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.UpdatePostUseCase
import javax.inject.Inject

class UpdatePostUseCaseImpl @Inject constructor(
        private val repository: PostRepository
) : UpdatePostUseCase {

    override fun invoke(postId: Long): Completable {
        return repository.fetchPost(postId)
    }
}