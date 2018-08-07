package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Completable
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.UpdateCommentsUseCase
import javax.inject.Inject

class UpdateCommentsUseCaseImpl @Inject constructor(
        private val repository: PostRepository
) : UpdateCommentsUseCase {

    override fun invoke(postId: Long): Completable {
        return repository.fetchComments(postId)
    }
}