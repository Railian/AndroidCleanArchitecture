package ua.raylyan.cleanarch.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ListFragment: Fragment() {

    private var uiClickListener: PostClickListener? = null
    companion object {
        fun netInstance():ListFragment {
            return ListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = view.findViewById<RecyclerView>(R.id.rvPostsList)
        list.layoutManager = LinearLayoutManager(view.context)
        val adapter = PostsListAdapter()
        adapter.setclickListener(this.activity as PostClickListener)
        val generatorData = PostsGenerator()
        adapter.setData(ArrayList(generatorData.generateDemoData()))
        list.adapter = adapter
    }

}