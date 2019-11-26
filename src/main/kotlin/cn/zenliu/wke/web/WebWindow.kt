package cn.zenliu.wke.web

import cn.zenliu.wke.header.*
import cn.zenliu.wke.lib.*
import jnr.ffi.Runtime

class WebWindow internal constructor(
	api: WkeLib,
	win: wkeWebView,
	runtime:Runtime
) : WebView(api, win,runtime){
	fun createRect(x: Int, y: Int, w: Int, h: Int) = Rect(runtime)
	fun showWindow(boolean: Boolean){
		api.wkeShowWindow(win,boolean)
	}
}
