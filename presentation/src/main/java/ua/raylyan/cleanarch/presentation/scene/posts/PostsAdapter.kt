package ua.raylyan.cleanarch.presentation.scene.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.presentation.R
import kotlin.properties.Delegates

class PostsAdapter : RecyclerView.Adapter<PostViewHolder>() {

    var posts: List<Post> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    private var onPostClickListener: OnPostClickListener? = null

    fun setOnPostClickListener(listener: OnPostClickListener?) {
        onPostClickListener = listener
    }

    override fun getItemCount(): Int = posts.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
        holder.itemView.setOnClickListener {
            onPostClickListener?.onPostClick(posts[position])
        }
    }
}