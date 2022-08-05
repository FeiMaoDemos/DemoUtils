package ink.liangxin.demoutils.utils

import android.widget.Toast
import ink.liangxin.demoutils.AppInfo

/**
 * Toast的封装类
 */

/**
 * 展示Toast
 * */
fun showToast(str: CharSequence) {
    runOnUIThread {
        showToastIgnoreThread(str)
    }
}

/**
 * showToast的封装
 * */
fun CharSequence.T() {
    showToast(this)
}

/**
 * 展示Toast，忽略当前执行的线程
 *
 * @param str 要展示的文本
 */
fun showToastIgnoreThread(str: CharSequence) {
    Toast.makeText(AppInfo.globalContext, str, Toast.LENGTH_SHORT).show()
}



