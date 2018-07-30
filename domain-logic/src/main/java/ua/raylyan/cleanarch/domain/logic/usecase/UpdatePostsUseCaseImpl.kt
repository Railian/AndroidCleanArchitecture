package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Completable
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.UpdatePostsUseCase

class UpdatePostsUseCaseImpl(
        private val repository: PostRepository
) : UpdatePostsUseCase {

    override fun invoke(): Completable {
        return repository.fetchPosts()
    }
}