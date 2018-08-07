package ua.raylyan.cleanarch.presentation.scene.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_posts.*
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.presentation.R
import ua.raylyan.cleanarch.presentation.scene.post.PostActivity
import ua.raylyan.cleanarch.presentation.util.BaseFragment
import ua.raylyan.cleanarch.presentation.util.observe
import ua.raylyan.cleanarch.presentation.util.onRefresh
import ua.raylyan.cleanarch.presentation.util.showToastWithError


class PostsFragment : BaseFragment() {

    companion object {
        fun newInstance(): PostsFragment {
            return PostsFragment()
        }
    }

    private val viewModel: PostsViewModel by viewModelProvider()

    private val postsAdapter = PostsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.posts, postsAdapter::posts::set)
        observe(viewModel.isUpdating, swipeRefreshLayout::setRefreshing)
        observe(viewModel.errors, ::showToastWithError)

        recyclerView.adapter = postsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divider)

        swipeRefreshLayout.onRefresh(viewModel::updatePosts)

        postsAdapter.setOnPostClickListener(object : OnPostClickListener {
            override fun onPostClick(post: Post) {
                startActivity(PostActivity.startIntent(requireContext(), post.id))
            }
        })
    }
}