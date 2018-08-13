package ua.raylyan.cleanarch.domain.contract.entity

data class Post (
        val userId: Long,
        val id: Long,
        val title: String,
        val body: String
)