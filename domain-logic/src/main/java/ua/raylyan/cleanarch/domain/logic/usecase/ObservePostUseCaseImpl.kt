package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.ObservePostUseCase
import javax.inject.Inject

class ObservePostUseCaseImpl @Inject constructor(
        private var repository: PostRepository
) : ObservePostUseCase {

    override fun invoke(postId: Long): Observable<Post> {
        return repository.observePost(postId)
    }
}