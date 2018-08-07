package ua.raylyan.cleanarch.domain.logic.usecase

import io.reactivex.Completable
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import ua.raylyan.cleanarch.domain.contract.usecase.UpdatePostsUseCase
import javax.inject.Inject

class UpdatePostsUseCaseImpl @Inject constructor(
        private val repository: PostRepository
) : UpdatePostsUseCase {

    override fun invoke(): Completable {
        return repository.fetchPosts()
    }
}