package ink.liangxin.demoutils.utils

import android.os.Handler
import android.os.Looper

/**
 * 线程相关工具类
 */

/**
 * 主线程使用的Handler
 * */
private val handler = Handler(Looper.getMainLooper())

/**
 * 判断当前线程是否是主线程
 * */
fun isUIThread() = Looper.getMainLooper() == Looper.myLooper()

/**
 * 在主线程执行一段代码
 *
 * @param block 要执行的代码
 */
fun runOnUIThread(block: () -> Unit) {
    if (isUIThread()) {
        block()
    } else {
        handler.post(block)
    }
}