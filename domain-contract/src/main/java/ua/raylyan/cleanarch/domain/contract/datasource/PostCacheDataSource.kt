package ua.raylyan.cleanarch.domain.contract.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post


interface PostCacheDataSource {

    fun removeAllPosts(): Completable
    fun removePosts(predicate: (post: Post) -> Boolean): Completable
    fun saveOrUpdatePosts(posts: List<Post>): Completable
    fun saveOrUpdatePost(post: Post): Completable
    fun observePosts(): Observable<List<Post>>
    fun observePosts(userId: Long): Observable<List<Post>>
    fun observePost(postId: Long): Observable<Post>

    fun removeAllComments(): Completable
    fun removeComments(predicate: (comment: Comment) -> Boolean): Completable
    fun saveOrUpdateComments(comments: List<Comment>): Completable
    fun observeComments(postId: Long): Observable<List<Comment>>
}