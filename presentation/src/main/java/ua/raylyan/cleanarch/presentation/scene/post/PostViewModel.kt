package ua.raylyan.cleanarch.presentation.scene.post

import io.reactivex.Completable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.domain.contract.usecase.ObserveCommentsUseCase
import ua.raylyan.cleanarch.domain.contract.usecase.ObservePostUseCase
import ua.raylyan.cleanarch.domain.contract.usecase.UpdateCommentsUseCase
import ua.raylyan.cleanarch.domain.contract.usecase.UpdatePostUseCase
import ua.raylyan.cleanarch.presentation.util.ReactiveViewModel
import ua.raylyan.cleanarch.presentation.util.applySchedulers
import javax.inject.Inject


class PostViewModel @Inject constructor(
        private val observePost: ObservePostUseCase,
        private val observeComments: ObserveCommentsUseCase,
        private val updatePost: UpdatePostUseCase,
        private val updateComments: UpdateCommentsUseCase
) : ReactiveViewModel() {

    val post by liveData<Post>()
    val comments by liveData<List<Comment>>()
    val isUpdating by liveData<Boolean>()
    val errors by singleLiveEvent<Throwable>()

    private val observingDisposable by disposable()
    private val updatingDisposable by disposable()

    private var postId: Long? = null

    fun startObservingPost(postId: Long) {
        observingDisposable.clear()
        this.postId = postId
        observePost(postId)
                .applySchedulers()
                .subscribeBy(
                        onNext = { post.update(it) },
                        onError = { errors.update(it) }
                ).addTo(compositeDisposable)
                .addTo(observingDisposable)
        observeComments(postId)
                .applySchedulers()
                .subscribeBy(
                        onNext = { comments.update(it) },
                        onError = { errors.update(it) }
                ).addTo(compositeDisposable)
                .addTo(observingDisposable)
        updatingDisposable.clear()
        updateComments(postId)
                .applySchedulers()
                .doOnSubscribe { isUpdating.update(true) }
                .doFinally { isUpdating.update(false) }
                .subscribeBy(
                        onError = { errors.update(it) }
                ).addTo(compositeDisposable)
                .addTo(updatingDisposable)
    }

    fun updatePostWithComments() {
        updatingDisposable.clear()
        val postId = this.postId
        when (postId) {
            null ->
                errors.update(NullPointerException("There is not any post that you are observing"))
            else ->
                Completable.mergeArrayDelayError(
                        updatePost(postId),
                        updateComments(postId)
                )
                        .applySchedulers()
                        .doOnSubscribe { isUpdating.update(true) }
                        .doFinally { isUpdating.update(false) }
                        .subscribeBy(
                                onError = { errors.update(it) }
                        ).addTo(compositeDisposable)
                        .addTo(updatingDisposable)
        }
    }
}