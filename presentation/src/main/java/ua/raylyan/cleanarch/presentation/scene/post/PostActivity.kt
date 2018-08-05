package ua.raylyan.cleanarch.presentation.scene.post

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ua.raylyan.cleanarch.presentation.R


class PostActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, PostFragment.newInstance())
                    .commit()
        }
    }
}