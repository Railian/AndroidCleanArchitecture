package ua.raylyan.cleanarch.presentation.util

import android.view.View

fun View.onClick(action: () -> Unit) =
        setOnClickListener { action() }