package com.devtokihjw.lib.util

import android.os.Parcelable

interface Callback<T> : Parcelable {

    fun callback(data: T)
}