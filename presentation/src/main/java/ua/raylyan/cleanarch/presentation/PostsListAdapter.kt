package ua.raylyan.cleanarch.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostsListAdapter: RecyclerView.Adapter<PostViewHolder>() {


    private var posts:MutableList<Post> = mutableListOf()
    private var inflater : LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        inflater = LayoutInflater.from(parent.context)
        return PostViewHolder(inflater.inflate(R.layout.,parent))
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       holder.initView(posts[position])
    }

   fun setData(posts:ArrayList<Post>){
        this.posts.addAll(posts)
   }
}

