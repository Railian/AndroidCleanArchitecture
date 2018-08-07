package ua.raylyan.cleanarch.presentation.util

import android.os.Bundle

fun Bundle.getLongOrNull(key: String): Long? = when (containsKey(key)) {
    true -> getLong(key)
    else -> null
}