package ua.raylyan.cleanarch.presentation.scene.posts

import android.os.Bundle
import ua.raylyan.cleanarch.presentation.R
import ua.raylyan.cleanarch.presentation.util.DaggerAppCompatActivity


class PostsActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, PostsFragment.newInstance())
                    .commit()
        }
    }
}