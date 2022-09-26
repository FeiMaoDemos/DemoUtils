package ink.liangxin.demoutils.activity.activitylist

import android.app.Activity
import android.content.Intent

/**
 * Activity相关工具
 */

/**
 * 启动Activity
 *
 * @param activity 当前Activity
 */
fun Class<out Activity>.open(activity: Activity) {
	activity.startActivity(
		Intent(
			activity, this
		)
	)
}