package ua.raylyan.cleanarch.platform.datasource

import io.reactivex.Single
import ua.raylyan.cleanarch.domain.contract.datasource.PostNetworkDataSource
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.platform.network.NetworkEntityAdapter.adapt
import ua.raylyan.cleanarch.platform.network.RetrofitFactory
import ua.raylyan.cleanarch.platform.network.service.PostService
import javax.inject.Inject

class PostNetworkDataSourceImpl @Inject constructor() : PostNetworkDataSource {
    private val api = RetrofitFactory.create<PostService>()
    override fun getPosts(): Single<List<Post>> = api.getPosts().map { it.map(::adapt) }
    override fun getPosts(userId: Long): Single<List<Post>> = api.getPosts(userId).map { it.map(::adapt) }
    override fun getPost(postId: Long): Single<Post> = api.getPost(postId).map(::adapt)
    override fun getComments(postId: Long): Single<List<Comment>> = api.getComments(postId).map { it.map(::adapt) }
}