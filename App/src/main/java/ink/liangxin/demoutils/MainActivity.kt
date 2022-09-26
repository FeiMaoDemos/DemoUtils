package ink.liangxin.demoutils

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ink.liangxin.demoutils.activity.activitylist.ActivityListActivity

class MainActivity: ActivityListActivity() {

	override val activityList: List<Pair<String, Class<out Activity>>> = listOf(
		"测试Activity" to TestActivity::class.java
	)

	override val recyclerView: RecyclerView by lazy {
		findViewById(R.id.activity_list)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}