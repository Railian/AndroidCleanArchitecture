package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.ObservePostsUseCase
import javax.inject.Inject

class ObservePostsUseCaseImpl @Inject constructor(
        private var repository: PostRepository
) : ObservePostsUseCase {

    override fun invoke(): Observable<List<Post>> {
        return repository.observePosts()
    }
}