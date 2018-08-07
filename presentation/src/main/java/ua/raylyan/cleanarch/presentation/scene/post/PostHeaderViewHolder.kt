package ua.raylyan.cleanarch.presentation.scene.post

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*
import ua.raylyan.cleanarch.domain.contract.entity.Post

class PostHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(post: Post) {
        itemView.textViewTitle.text = post.title
        itemView.textViewBody.text = post.body
    }
}