package ua.raylyan.cleanarch.presentation.util

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment


fun <T : Fragment> T.withArguments(vararg pairs: Pair<String, Any?>): T {
    arguments = bundleOf(*pairs)
    return this
}

fun Fragment.getArgumentLong(key: String): Long {
    return arguments?.getLongOrNull(key) ?: throw NullPointerException()
}