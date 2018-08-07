package ua.raylyan.cleanarch.presentation.scene.post

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_comment.view.*
import ua.raylyan.cleanarch.domain.contract.entity.Comment

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(comment: Comment) {
        itemView.textViewEmail.text = comment.email
        itemView.textViewBody.text = comment.body
    }
}