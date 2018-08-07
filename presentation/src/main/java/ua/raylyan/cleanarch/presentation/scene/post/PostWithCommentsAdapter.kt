package ua.raylyan.cleanarch.presentation.scene.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.raylyan.cleanarch.domain.contract.entity.Comment
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.presentation.R
import kotlin.properties.Delegates

class PostWithCommentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_POST_HEADER = 0
        private const val TYPE_COMMENT_HEADER = 1
        private const val TYPE_COMMENT = 2
    }

    var post by Delegates.observable(null as Post?) { _, _, _ -> notifyDataSetChanged() }
    var comments: List<Comment> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun getItemCount(): Int = when {
        post == null -> 0
        comments.isEmpty() -> 1 /* post header */
        else -> 1 /* post header */ + 1 /* comment header */ + comments.count()
    }

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> TYPE_POST_HEADER
        1 -> TYPE_COMMENT_HEADER
        else -> TYPE_COMMENT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_POST_HEADER -> {
                val itemView = inflater.inflate(R.layout.item_post_header, parent, false)
                PostHeaderViewHolder(itemView)
            }
            TYPE_COMMENT_HEADER -> {
                val itemView = inflater.inflate(R.layout.item_comment_header, parent, false)
                CommentHeaderViewHolder(itemView)
            }
            TYPE_COMMENT -> {
                val itemView = inflater.inflate(R.layout.item_comment, parent, false)
                CommentViewHolder(itemView)
            }
            else -> throw IllegalArgumentException("Not supported view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostHeaderViewHolder -> {
                holder.bind(post!!)
            }
            is CommentViewHolder -> {
                val comment = comments[position - 2]
                holder.bind(comment)
                holder.itemView.setOnClickListener {}
            }
        }
    }
}