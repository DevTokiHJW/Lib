package com.devtokihjw.lib.util

import android.net.Uri
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.FileDataSource
import java.io.File

fun buildMediaSource(uri: Uri) = ProgressiveMediaSource.Factory(DataSource.Factory {
    FileDataSource().apply {
        open(DataSpec(uri))
    }
}).createMediaSource(uri)

fun List<File>.fileListtoMediaSourceList() = arrayListOf<MediaSource>().apply {
    this@fileListtoMediaSourceList.forEach { file ->
        add(buildMediaSource(Uri.fromFile(file)))
    }
}