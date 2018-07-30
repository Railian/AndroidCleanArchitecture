package ua.raylyan.cleanarch.domain.logic.ropository

import io.reactivex.Completable
import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.datasource.PostCacheDataSource
import ua.raylyan.cleanarch.domain.contract.datasource.PostNetworkDataSource
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.domain.contract.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
        private val network: PostNetworkDataSource,
        private val cache: PostCacheDataSource
) : PostRepository {

    override fun fetchPosts(): Completable {
        return network.getPosts().flatMapCompletable {
            cache.removeAllPosts().andThen(cache.saveOrUpdatePosts(it))
        }
    }

    override fun observePosts(): Observable<List<Post>> {
        return cache.observePosts()
    }

    override fun fetchPosts(userId: Long): Completable {
        return network.getPosts(userId).flatMapCompletable {
            cache.removePosts { it.userId == userId }.andThen(cache.saveOrUpdatePosts(it))
        }
    }

    override fun observePosts(userId: Long): Observable<List<Post>> {
        return cache.observePosts(userId)
    }

    override fun fetchPost(postId: Long): Completable {
        return network.getPost(postId).flatMapCompletable(cache::saveOrUpdatePost)
    }

    override fun observePost(postId: Long): Observable<Post> {
        return cache.observePost(postId)
    }

    override fun fetchComments(postId: Long): Completable {
        return network.getComments(postId).flatMapCompletable {
            cache.removeComments { it.postId == postId }.andThen(cache.saveOrUpdateComments(it))
        }
    }

    override fun observeComments(postId: Long): Observable<List<Comment>> {
        return cache.observeComments(postId)
    }
}