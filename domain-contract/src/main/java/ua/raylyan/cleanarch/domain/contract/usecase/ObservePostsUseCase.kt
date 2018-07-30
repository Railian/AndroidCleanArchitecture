package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Post

interface ObservePostsUseCase {
    operator fun invoke(): Observable<List<Post>>
}