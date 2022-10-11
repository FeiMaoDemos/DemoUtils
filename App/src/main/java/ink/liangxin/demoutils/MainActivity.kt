package ink.liangxin.demoutils

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ink.liangxin.demoutils.activity.activitylist.ActivityListActivity
import ink.liangxin.demoutils.utils.T

class MainActivity: ActivityListActivity() {

	override val activityList: List<Pair<String, Class<out Activity>>> = listOf(
		"测试Activity" to TestActivity::class.java
	)

	override val recyclerView: RecyclerView by lazy {
		findViewById(R.id.activity_list)
	}

	override val permissions: List<String> = listOf(
		android.Manifest.permission.ACCESS_NETWORK_STATE,
		android.Manifest.permission.CAMERA
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		permissionsCallback = {
			"权限申请成功".T()
		}
	}
}