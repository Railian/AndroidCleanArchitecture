package ua.raylyan.cleanarch.domain.contract.entity

data class Comment(
        val postId: Long,
        val id: Long,
        val email: String,
        val body: String
)