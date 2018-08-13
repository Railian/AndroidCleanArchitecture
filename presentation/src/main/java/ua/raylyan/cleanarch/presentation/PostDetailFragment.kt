package ua.raylyan.cleanarch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.post_detail_fragment.*

class PostDetailFragment : Fragment() {

    companion object {
        fun netInstance(userId: Long):PostDetailFragment {
            val args = Bundle()
            args.putLong("post",userId)
            val detailFragment = PostDetailFragment()
            detailFragment.arguments = args
            return detailFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.post_detail_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = arguments?.get("post").toString()
    }
}