package ua.raylyan.cleanarch.platform.network

import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.platform.network.entity.RetrofitComment
import ua.raylyan.cleanarch.platform.network.entity.RetrofitPost

internal object NetworkEntityAdapter {
    internal fun adapt(it: RetrofitPost): Post = Post(it.userId, it.id, it.title, it.body)
    internal fun adapt(it: RetrofitComment): Comment = Comment(it.postId, it.id, it.email, it.body)
}