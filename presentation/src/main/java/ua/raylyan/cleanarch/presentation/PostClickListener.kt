package ua.raylyan.cleanarch.presentation

import ua.raylyan.cleanarch.domain.contract.entity.Post

interface PostClickListener {
     fun onClick(post: Post)
}