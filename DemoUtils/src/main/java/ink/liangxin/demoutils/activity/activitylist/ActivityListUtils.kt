package ink.liangxin.demoutils.activity.activitylist

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * 默认的请求权限的请求码
 * */
private const val REQUEST_PERMISSION_CODE = 123333

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
	 * 如果需要权限，把所有需要申请的权限列在这里
	 * */
	abstract val permissions: List<String>

	/**
	 * 权限申请成功要执行的代码
	 * */
	var permissionsCallback: (() -> Unit)? = null

	/**
	 * 用来填充Activity集合数据的Adapter
	 */
	private val myAdapter by lazy {
		MyAdapter(activityList)
	}

	override fun onStart() {
		super.onStart()
		recyclerView.initActivityList(this)

		val need = permissions.filter {
			ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
		}

		if(need.isEmpty().not()){
			ActivityCompat.requestPermissions(this, need.toTypedArray(), REQUEST_PERMISSION_CODE)
		}else{
			permissionsCallback?.invoke()
		}
	}

	override fun onRequestPermissionsResult(
		requestCode: Int,
		permissions: Array<out String>,
		grantResults: IntArray
	) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		when(requestCode){
			REQUEST_PERMISSION_CODE -> {
				permissionsCallback?.invoke()
			}
			else -> {

			}
		}
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