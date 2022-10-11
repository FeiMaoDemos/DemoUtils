package ink.liangxin.demoutils

import android.app.Application

/**
 *
 *
 * @author liangxin01
 * @date 2022/10/11
 */
class MyApplication: Application() {

	override fun onCreate() {
		super.onCreate()
		AppInfo.initDemoUtils(this)
	}

}