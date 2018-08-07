package ua.raylyan.cleanarch.platform.cache.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import ua.raylyan.cleanarch.domain.contract.datasource.PostCacheDataSource
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post
import javax.inject.Inject

class PostCacheDataSourceImpl @Inject constructor() : PostCacheDataSource {

    private val cachedPosts: BehaviorSubject<List<Post>> = BehaviorSubject.createDefault(emptyList())
    private val cachedComments: BehaviorSubject<List<Comment>> = BehaviorSubject.create()

    override fun removeAllPosts(): Completable {
        return Completable.fromCallable { cachedPosts.onNext(emptyList()) }
    }

    override fun removePosts(predicate: (post: Post) -> Boolean): Completable {
        return Completable.fromCallable {
            val result = cachedPosts.value?.toMutableList() ?: mutableListOf()
            result.removeAll(predicate)
            cachedPosts.onNext(result)
        }
    }

    override fun saveOrUpdatePosts(posts: List<Post>): Completable {
        return Completable.fromCallable {
            val result = cachedPosts.value?.toMutableList() ?: mutableListOf()
            posts.forEach { post ->
                result.removeAll { it.id == post.id }
                result.add(post)
            }
            cachedPosts.onNext(result)
        }
    }

    override fun saveOrUpdatePost(post: Post): Completable {
        return Completable.fromCallable {
            val result = cachedPosts.value?.toMutableList() ?: mutableListOf()
            result.removeAll { it.id == post.id }
            result.add(post)
            this.cachedPosts.onNext(result)
        }
    }

    override fun observePosts(): Observable<List<Post>> {
        return cachedPosts.distinctUntilChanged()
    }

    override fun observePosts(userId: Long): Observable<List<Post>> {
        return cachedPosts.map { it.filter { it.userId == userId } }.distinctUntilChanged()
    }

    override fun observePost(postId: Long): Observable<Post> {
        return cachedPosts
                .map { it.filter { it.id == postId } }
                .filter { it.isNotEmpty() }
                .map { it.single() }
                .distinctUntilChanged()
    }


    override fun removeAllComments(): Completable {
        return Completable.fromCallable { cachedComments.onNext(emptyList()) }
    }

    override fun removeComments(predicate: (comment: Comment) -> Boolean): Completable {
        return Completable.fromCallable {
            val result = cachedComments.value?.toMutableList() ?: mutableListOf()
            result.removeAll(predicate)
            cachedComments.onNext(result)
        }
    }

    override fun saveOrUpdateComments(comments: List<Comment>): Completable {
        return Completable.fromCallable {
            val result = cachedComments.value?.toMutableList() ?: mutableListOf()
            comments.forEach { comment ->
                result.removeAll { it.id == comment.id }
                result.add(comment)
            }
            cachedComments.onNext(result)
        }
    }

    override fun observeComments(postId: Long): Observable<List<Comment>> {
        return cachedComments
                .map { it.filter { it.postId == postId } }
                .distinctUntilChanged()
    }
}