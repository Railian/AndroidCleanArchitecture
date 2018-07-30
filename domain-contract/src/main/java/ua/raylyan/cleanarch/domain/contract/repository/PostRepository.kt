package ua.raylyan.cleanarch.domain.contract.repository

import io.reactivex.Completable
import io.reactivex.Observable
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post

interface PostRepository {

    fun fetchPosts(): Completable
    fun observePosts(): Observable<List<Post>>

    fun fetchPosts(userId: Long): Completable
    fun observePosts(userId: Long): Observable<List<Post>>

    fun fetchPost(postId: Long): Completable
    fun observePost(postId: Long): Observable<Post>

    fun fetchComments(postId: Long): Completable
    fun observeComments(postId: Long): Observable<List<Comment>>
}