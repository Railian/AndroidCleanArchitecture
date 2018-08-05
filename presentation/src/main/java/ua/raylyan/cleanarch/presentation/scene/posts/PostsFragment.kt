package ua.raylyan.cleanarch.presentation.scene.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.raylyan.cleanarch.presentation.R


class PostsFragment : Fragment() {

    companion object {
        fun newInstance() = PostsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }
}