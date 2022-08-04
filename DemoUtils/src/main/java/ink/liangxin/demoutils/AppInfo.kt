package ink.liangxin.demoutils

import android.app.Application

/**
 * App的基本信息
 */
object AppInfo {

    /**
     * 全局Context，一般指Application
     */
    lateinit var globalContext: Application

    /**
     * 初始化DemoUtils工具
     * */
    fun initDemoUtils(application: Application){
        globalContext = application
    }

}