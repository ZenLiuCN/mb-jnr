package cn.zenliu.wke.web

import cn.zenliu.wke.header.*
import cn.zenliu.wke.js.*
import cn.zenliu.wke.lib.*
import jnr.ffi.*

open class WebView internal constructor(
	protected val api: WkeLib,
	internal val win: wkeWebView,
	protected val runtime: Runtime,
	protected val hwnd: HWND = api.wkeGetWindowHandle(win)
) {
	var title: String
		get() = api.wkeGetTitle(win)
		set(value) = api.wkeSetWindowTitle(win, value)
	val height: Int get() = api.wkeGetHeight(win)
	val width: Int get() = api.wkeGetWidth(win)
	val contentHeight: Int get() = api.wkeGetContentHeight(win)
	val contentWidth: Int get() = api.wkeGetContentWidth(win)
	val canGoBack get() = api.wkeCanGoBack(win)
	val canGoForward get() = api.wkeCanGoForward(win)
	val url get() = api.wkeGetURL(win)

	fun load(url: String) = api.wkeLoadURL(win, url)
	fun goBack() = api.wkeGoBack(win)
	fun goForward() = api.wkeGoForward(win)
	fun resize(w: Int, h: Int) = api.wkeResize(win, w, h)
	fun reload() = api.wkeReload(win)
	fun newWebView() = api.wkeCreateWebView().let { WebView(api, it, runtime, hwnd) }
	fun onUrlChange2(callback: (WebView, url: String) -> Unit) {
		val call = object : URLChangedCallback2 {
			override fun invoke(webView: wkeWebView, param: VoidPtr, frameId: wkeWebFrameHandle, url: wkeString) {
				callback.invoke(this@WebView, api.wkeGetString(url))
			}
		}
		api.wkeOnURLChanged2(win, call, null)
	}
	val jsEnv get() = Context(api,this,runtime,api.wkeGlobalExec(win))
	fun runJs(script: String) = api.wkeRunJS(win, script)
}
