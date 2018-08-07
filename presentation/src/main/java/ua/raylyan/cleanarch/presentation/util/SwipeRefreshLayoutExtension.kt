package ua.raylyan.cleanarch.presentation.util

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun SwipeRefreshLayout.onRefresh(action: () -> Unit) =
        setOnRefreshListener { action() }