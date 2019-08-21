package com.devtokihjw.lib.exoPlayer

import com.google.android.exoplayer2.source.MediaSource

class MediaSourceManager {

    private val list = arrayListOf<MediaSource>()

    private var index = 0

    fun getFirstMediaSource(): MediaSource {
        index = 0
        return getMediaSource(index)
    }

    fun getNextMediaSource(): MediaSource {
        index++
        return if (index >= list.size) {
            getFirstMediaSource()
        } else {
            getMediaSource(index)
        }
    }

    fun getMediaSource(index: Int) = list[index]

    fun updateList(tmpList: List<MediaSource>) {
        list.clear()
        list.addAll(tmpList)
        index = -1
    }
}