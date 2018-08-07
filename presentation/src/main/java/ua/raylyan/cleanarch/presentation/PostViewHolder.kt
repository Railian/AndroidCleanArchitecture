package ua.raylyan.cleanarch.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.raylyan.cleanarch.domain.contract.entity.Post

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var title: TextView
    private lateinit var body: TextView
    private lateinit var rank: TextView
    private lateinit var number: TextView



    fun initView(post: Post){
        title = itemView.findViewById(R.id.title)
        body = itemView.findViewById(R.id.body)
        number = itemView.findViewById(R.id.number)


        number.text = post.id.toString()
        title.text = post.title
        body.text = post.body

    }
}