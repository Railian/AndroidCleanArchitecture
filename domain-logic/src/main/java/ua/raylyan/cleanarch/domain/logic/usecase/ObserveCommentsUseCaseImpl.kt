package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.ObserveCommentsUseCase
import javax.inject.Inject

class ObserveCommentsUseCaseImpl @Inject constructor(
        private var repository: PostRepository
) : ObserveCommentsUseCase {

    override fun invoke(postId: Long): Observable<List<Comment>> {
        return repository.observeComments(postId)
    }
}