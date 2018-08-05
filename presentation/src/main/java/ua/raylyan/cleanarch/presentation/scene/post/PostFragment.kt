package ua.raylyan.cleanarch.presentation.scene.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.raylyan.cleanarch.presentation.R


class PostFragment : Fragment() {

    companion object {
        fun newInstance() = PostFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }
}