package ink.liangxin.demoutils

import android.content.Context

/**
 * 将dp值转换为px
 * */
fun dp2px(dipValue: Float, context: Context): Float {
    val scale: Float = context.resources.displayMetrics.density
    return dipValue * scale + 0.5f
}

/**
 * 将px值转换为dp
 * */
fun px2dp(pxValue: Float, context: Context): Float {
    val scale: Float = context.resources.displayMetrics.density
    return (pxValue - 0.5f) / scale
}

/**
 * dp2px的封装
 */
fun Float.dp2px() = dp2px(this, AppInfo.globalContext)

/**
 * px2dp的封装
 * */
fun Float.px2dp() = px2dp(this, AppInfo.globalContext)