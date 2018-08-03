package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Completable
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.FetchPostsUseCase
import javax.inject.Inject

class FetchPostsUseCaseImpl @Inject constructor(
        private val repository: PostRepository
) : FetchPostsUseCase {

    override fun invoke(): Completable {
        return repository.fetchPosts()
    }
}