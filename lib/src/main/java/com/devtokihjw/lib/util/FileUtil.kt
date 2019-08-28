package com.devtokihjw.lib.util

import android.os.AsyncTask
import java.io.File
import java.io.InputStream

fun File.readString() = bufferedReader().useLines { lines ->
    lines.fold("") { working, line ->
        "$working\n$line"
    }
}

fun File.writeString(text: String) {
    bufferedWriter().use { writer ->
        writer.write(text)
    }
}

fun File.writeFile(inputStream: InputStream, progressUpdate: ((Int) -> Unit)? = null) {
    outputStream().use { outputStream ->
        inputStream.use { inputStream ->
            val mByteArray = ByteArray(DEFAULT_BUFFER_SIZE)
            val size = inputStream.available()
            var read: Int
            var readSize = 0
            while (inputStream.read(mByteArray).also { read = it } > -1) {
                outputStream.write(mByteArray, 0, read)
                readSize += read
                progressUpdate?.let { progressUpdate((readSize * 100f / size).toInt()) }
            }
            outputStream.flush()
        }
    }
}

class DownloadFileTask(private val filePath: String, private val fileName: String, private val inputStream: InputStream, private val preExecute: () -> Unit, private val progressUpdate: (Int) -> Unit, private val success: (Boolean, String?) -> Unit) : AsyncTask<Any, Int, Any>() {

    override fun onPreExecute() {
        preExecute()
    }

    override fun doInBackground(vararg p0: Any?): Any? {
        printLog("filePath", "$filePath$fileName")
        File("$filePath$fileName").writeFile(inputStream) {
            publishProgress(it)
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        values[0]?.let { progress ->
            progressUpdate(progress)
        }
    }

    override fun onPostExecute(result: Any?) {
        success(true, null)
    }
}