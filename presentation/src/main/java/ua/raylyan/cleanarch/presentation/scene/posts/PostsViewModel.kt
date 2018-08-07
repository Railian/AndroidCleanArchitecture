package ua.raylyan.cleanarch.presentation.scene.posts

import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.domain.contract.usecase.ObservePostsUseCase
import ua.raylyan.cleanarch.domain.contract.usecase.UpdatePostsUseCase
import ua.raylyan.cleanarch.presentation.util.ReactiveViewModel
import ua.raylyan.cleanarch.presentation.util.applySchedulers
import javax.inject.Inject


class PostsViewModel @Inject constructor(
        private val observePosts: ObservePostsUseCase,
        private val updatePosts: UpdatePostsUseCase
) : ReactiveViewModel() {

    val posts by liveData<List<Post>>()
    val isUpdating by liveData<Boolean>()
    val errors by singleLiveEvent<Throwable>()

    private val fetchingDisposable by disposable()

    init {
        observePosts()
                .applySchedulers()
                .subscribeBy(
                        onNext = { posts.update(it) },
                        onError = { errors.update(it) }
                ).addTo(compositeDisposable)
        updatePosts()
    }

    fun updatePosts() {
        fetchingDisposable.clear()
        updatePosts.invoke()
                .applySchedulers()
                .doOnSubscribe { isUpdating.update(true) }
                .doFinally { isUpdating.update(false) }
                .subscribeBy(
                        onError = { errors.update(it) }
                ).addTo(compositeDisposable)
                .addTo(fetchingDisposable)
    }
}