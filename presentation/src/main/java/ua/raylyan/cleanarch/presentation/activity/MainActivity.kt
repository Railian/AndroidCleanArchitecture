package ua.raylyan.cleanarch.presentation.activity

import android.os.Bundle
import android.util.Log
import ua.raylyan.cleanarch.domain.contract.entity.Post
import ua.raylyan.cleanarch.presentation.*

class MainActivity : DaggerAppCompatActivity(), PostClickListener{



    private var listFragment: ListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, ListFragment.netInstance()).commit()
    }



    override fun onClick(post: Post) {
        supportFragmentManager.beginTransaction().addToBackStack("").add(R.id.container, PostDetailFragment.netInstance(post.userId)).commit()
    }
    }
