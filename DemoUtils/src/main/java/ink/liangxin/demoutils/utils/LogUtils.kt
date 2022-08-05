package ink.liangxin.demoutils.utils

import android.util.Log


fun logd(tag: String, log: String) {
    printLog(tag, log, LogLevel.D)
}

fun String.Ld(tag: String = "DemoLog") {
    logd(tag, this)
}

private enum class LogLevel {
    D
}

private fun printLog(tag: String, log: String, logLevel: LogLevel) {
    when (logLevel) {
        LogLevel.D -> {
            Log.d(tag, log)
        }
    }
}