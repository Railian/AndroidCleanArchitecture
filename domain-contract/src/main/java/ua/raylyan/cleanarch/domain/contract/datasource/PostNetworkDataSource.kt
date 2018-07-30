package ua.raylyan.cleanarch.domain.contract.datasource

import io.reactivex.Single
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post

interface PostNetworkDataSource {
    fun getPosts(): Single<List<Post>>
    fun getPosts(userId: Long): Single<List<Post>>
    fun getPost(postId: Long): Single<Post>
    fun getComments(postId: Long): Single<List<Comment>>
}