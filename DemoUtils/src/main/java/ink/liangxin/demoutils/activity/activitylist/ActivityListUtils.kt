package ink.liangxin.demoutils.activity.activitylist

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * 用于展示Activity入口的Activity
 */
abstract class ActivityListActivity : AppCompatActivity() {

	/**
	 * 待展示的Activity列表，需要子类提供
	 * */
	abstract val activityList: List<Pair<String, Class<out Activity>>>

	/**
	 * 列表控件，需要子类提供
	 * */
	abstract val recyclerView: RecyclerView

	/**
	 * 用来填充Activity集合数据的Adapter
	 */
	private val myAdapter by lazy {
		MyAdapter(activityList)
	}

	override fun onStart() {
		super.onStart()
		recyclerView.initActivityList(this)
	}

	/**
	 * 使用Activity集合数据初始化RecyclerView列表
	 *
	 * @param context
	 */
	private fun RecyclerView.initActivityList(context: Context) {
		layoutManager = LinearLayoutManager(context)
		adapter = myAdapter
		addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
	}

	private class MyAdapter(val activityList: List<Pair<String, Class<out Activity>>>) :
		RecyclerView.Adapter<MyViewHolder>() {
		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
			MyViewHolder(TextView(parent.context).apply {
				layoutParams =
					RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 200)
				gravity = Gravity.CENTER
			})

		override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
			(holder.itemView as TextView).text = activityList[position].first
			holder.itemView.setOnClickListener {
				activityList[position].second.open(holder.itemView.context as Activity)
			}
		}

		override fun getItemCount() = activityList.size

	}

	private class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}