package cn.zenliu.wke

import cn.zenliu.wke.header.*
import jnr.ffi.*

typealias WKE_CB_URLCHANGE_2 = (WKE.WebView, url: String) -> Unit

class WKE private constructor() {
	private val api = LibraryLoader.create(WkeLib::class.java).load("miniblink_x64")
	private val runtime = Runtime.getRuntime(api)

	init {
		api.wkeInit()
	}


	private fun createWebWindow(
		x: Int, y: Int, w: Int, h: Int, type: WindowType, parent: Pointer? = null) = api.wkeCreateWebWindow(
		type.value, parent, x, y, w, h).let { WebView(it) }

	inner class WebView internal constructor(
		private val win: wkeWebView,
		private val hwnd: HWND = api.wkeGetWindowHandle(win)
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
		fun newWebView() = api.wkeCreateWebView().let { WebView(it) }
		fun onUrlChange2(callback: WKE_CB_URLCHANGE_2) {
			val call = object : wkeURLChangedCallback2 {
				override fun invoke(webView: wkeWebView, param: Pointer?, frameId: wkeWebFrameHandle, url: wkeString) {
					callback.invoke(this@WebView, api.wkeGetString(url))
				}
			}
			api.wkeOnURLChanged2(win, call, null)
		}

		//api
		fun createRect(x: Int, y: Int, w: Int, h: Int) = Rect(x, y, w, h, runtime)
	}

	companion object {
		private lateinit var lib: WKE
		fun init() {
			if (this::lib.isInitialized) return
			lib = WKE()
		}

		fun createWebWindow(
			x: Int, y: Int, w: Int, h: Int, type: WindowType = WindowType.WINDOW_TYPE_POPUP, parent: Pointer? = null) = lib
			.createWebWindow(x, y, w, h, type, parent)
	}
}
