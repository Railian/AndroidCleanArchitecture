package ua.raylyan.cleanarch.presentation.util

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Context.showToastWithError(error: Throwable) =
        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()

fun Fragment.showToastWithError(error: Throwable) =
        requireContext().showToastWithError(error)