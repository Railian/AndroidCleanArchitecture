package ua.raylyan.cleanarch.presentation.scene.posts

import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.domain.contract.usecase.FetchPostsUseCase
import ua.raylyan.cleanarch.domain.contract.usecase.ObservePostsUseCase
import ua.raylyan.cleanarch.presentation.util.ReactiveViewModel
import ua.raylyan.cleanarch.presentation.util.applySchedulers
import javax.inject.Inject


@Suppress("unused", "CanBeParameter", "MemberVisibilityCanBePrivate")
class PostsViewModel @Inject constructor(
        private val observePosts: ObservePostsUseCase,
        private val fetchPosts: FetchPostsUseCase
) : ReactiveViewModel() {

    val posts by liveData<List<Post>>()
    val arePostsUpdating by liveData<Boolean>()
    val errors by singleLiveEvent<Throwable>()

    init {
        observePosts()
                .applySchedulers()
                .subscribeBy(
                        onNext = { posts.update(it) },
                        onError = { errors.update(it) }
                ).addTo(compositeDisposable)
    }

    fun updatePosts() {
        fetchPosts()
                .doOnSubscribe { arePostsUpdating.update(true) }
                .doFinally { arePostsUpdating.update(false) }
                .applySchedulers()
                .subscribeBy(
                        onError = { errors.update(it) }
                )
                .addTo(compositeDisposable)
    }
}