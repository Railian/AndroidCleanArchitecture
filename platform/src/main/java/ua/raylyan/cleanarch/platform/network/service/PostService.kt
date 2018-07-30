package ua.raylyan.cleanarch.platform.network.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.raylyan.cleanarch.platform.network.entity.RetrofitComment
import ua.raylyan.cleanarch.platform.network.entity.RetrofitPost

internal interface PostService {

    @GET("/posts")
    fun getPosts(): Single<List<RetrofitPost>>

    @GET("/posts")
    fun getPosts(
            @Query("userId") userId: Long
    ): Single<List<RetrofitPost>>

    @GET("/posts/{postId}")
    fun getPost(
            @Path("postId") postId: Long
    ): Single<RetrofitPost>

    @GET("/posts/{postId}/comments")
    fun getComments(
            @Path("postId") postId: Long
    ): Single<List<RetrofitComment>>
}