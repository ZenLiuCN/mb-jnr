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
	val isDocumentReady get()=api.wkeIsDocumentReady(win)

	fun load(url: String) = api.wkeLoadURL(win, url)
	fun goBack() = api.wkeGoBack(win)
	fun goForward() = api.wkeGoForward(win)
	fun resize(w: Int, h: Int) = api.wkeResize(win, w, h)
	fun reload() = api.wkeReload(win)
	fun newWebView() = api.wkeCreateWebView().let { WebView(api, it, runtime, hwnd) }

	fun onUrlChange2(callback: (WebView, url: String) -> Unit) {
		api.wkeOnURLChanged2(win, object : URLChangedCallback2 {
			override fun invoke(webView: wkeWebView, param: VoidPtr, frameId: wkeWebFrameHandle, url: WkeString) {
				callback.invoke(this@WebView, api.wkeGetString(url))
			}
		}, null)
	}

	fun onUrlChange(callback: (WebView, url: String) -> Unit) {
		api.wkeOnURLChanged(win, object : URLChangedCallback {
			override fun invoke(webView: wkeWebView, param: VoidPtr, url: WkeString) {
				callback.invoke(this@WebView, api.wkeGetString(url))
			}
		}, null)
	}

	fun onConsole(callback: (
		view: WebView,
		level: ConsoleLevel,
		message: String,
		sourceLine: Int, stackTrace: String
	) -> Unit) {
		api.wkeOnConsole(win, object : ConsoleCallback {
			override fun invoke(webView: wkeWebView, param: VoidPtr, level: ConsoleLevel, message: WkeString, sourceLine: Int, stackTrace: WkeString?) {
				//todo some bug with stackTrace
				//println("trace"+stackTrace?.let { api.wkeGetString(it) })
				println("stack trace : ${stackTrace?.address()}")
				callback.invoke(
					this@WebView,
					level,
					api.wkeGetString(message),
					sourceLine,
					stackTrace?.takeIf { it.address()>10000 }?.let { api.wkeGetString(it) }?:""
				)
			}

		}, null)
	}
	fun onDocumentReady(callback: (WebView) -> Unit){
		api.wkeOnDocumentReady(win,object :DocumentReadyCallback{
			override fun invoke(webView: wkeWebView, param: VoidPtr) {
				callback.invoke(this@WebView)
			}
		},null)
	}
	fun onDocumentReady2(callback: (WebView) -> Unit){
		api.wkeOnDocumentReady2(win,object :DocumentReady2Callback{
			override fun invoke(webView: wkeWebView, param: VoidPtr, frameId: WebFrameHandle) {
				callback.invoke(this@WebView)
			}
		},null)
	}
	val jsEnv get() = Context(api, this, runtime, api.wkeGlobalExec(win))
	fun runJs(script: String) = api.wkeRunJS(win, script)
}
