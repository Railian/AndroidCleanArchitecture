package ua.raylyan.cleanarch.presentation.scene.posts

import ua.raylyan.cleanarch.domain.contract.entity.Post

interface OnPostClickListener {
    fun onPostClick(post: Post)
}