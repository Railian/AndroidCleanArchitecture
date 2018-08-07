package ua.raylyan.cleanarch.presentation.scene.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_posts.*
import ua.raylyan.cleanarch.presentation.R
import ua.raylyan.cleanarch.presentation.util.*


class PostFragment : BaseFragment() {

    companion object {

        private const val ARG_POST_ID = "arg:postId"

        fun newInstance(postId: Long): PostFragment {
            return PostFragment().withArguments(
                    ARG_POST_ID to postId
            )
        }
    }

    private val viewModel: PostViewModel by viewModelProvider()

    private val postWithCommentsAdapter = PostWithCommentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.startObservingPost(getArgumentLong(ARG_POST_ID))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.post, postWithCommentsAdapter::post::set)
        observe(viewModel.comments, postWithCommentsAdapter::comments::set)
        observe(viewModel.isUpdating, swipeRefreshLayout::setRefreshing)
        observe(viewModel.errors, ::showToastWithError)

        recyclerView.adapter = postWithCommentsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        swipeRefreshLayout.onRefresh(viewModel::updatePostWithComments)
    }
}