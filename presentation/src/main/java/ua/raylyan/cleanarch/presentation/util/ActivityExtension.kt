package ua.raylyan.cleanarch.presentation.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

fun <T : Intent> T.withExtras(vararg pairs: Pair<String, Any?>): T {
    putExtras(bundleOf(*pairs))
    return this
}

fun AppCompatActivity.getExtraLong(key: String): Long {
    return intent.extras.getLongOrNull(key) ?: throw NullPointerException()
}