package ua.raylyan.cleanarch.presentation.scene.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import ua.raylyan.cleanarch.presentation.R
import ua.raylyan.cleanarch.presentation.util.BaseActivity
import ua.raylyan.cleanarch.presentation.util.getExtraLong
import ua.raylyan.cleanarch.presentation.util.withExtras


class PostActivity : BaseActivity() {

    companion object {

        private const val EXTRA_POST_ID = "extra:postId"

        fun startIntent(context: Context, postId: Long): Intent {
            return Intent(context, PostActivity::class.java).withExtras(
                    EXTRA_POST_ID to postId
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val postFragment = PostFragment.newInstance(getExtraLong(EXTRA_POST_ID))
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, postFragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}