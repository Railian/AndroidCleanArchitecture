package ua.raylyan.cleanarch.domain.contract.usecase

import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Comment

interface ObserveCommentsUseCase {
    operator fun invoke(postId: Long): Observable<List<Comment>>
}