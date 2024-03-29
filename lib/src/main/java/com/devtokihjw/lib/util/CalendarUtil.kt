package com.devtokihjw.lib.util

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatOfyyyyMMdd() = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(time)

fun Calendar.formatOfHHmm() = SimpleDateFormat("HH:mm", Locale.getDefault()).format(time)

fun Calendar.formatOfHH() = SimpleDateFormat("HH", Locale.getDefault()).format(time)

fun Long.formatOfyyyyMMddHHmmss() = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().apply { timeInMillis = this@formatOfyyyyMMddHHmmss }.time)

fun Long?.timeMillisToCalendar() = Calendar.getInstance().apply {
    timeInMillis = this@timeMillisToCalendar ?: 0
}