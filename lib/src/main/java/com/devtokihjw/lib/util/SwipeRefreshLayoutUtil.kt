package com.devtokihjw.lib.util

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun SwipeRefreshLayout?.show() {
    this?.let {
        isRefreshing = true
    }
}

fun SwipeRefreshLayout?.hide() {
    this?.let {
        isRefreshing = false
    }
}