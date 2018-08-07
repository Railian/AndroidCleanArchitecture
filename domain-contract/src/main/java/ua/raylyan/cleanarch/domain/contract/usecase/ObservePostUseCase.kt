package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Post

interface ObservePostUseCase {
    operator fun invoke(postId: Long): Observable<Post>
}