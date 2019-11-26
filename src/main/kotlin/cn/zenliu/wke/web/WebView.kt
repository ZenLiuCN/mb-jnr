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
	//<editor-fold desc="Status">
	var title: String
		get() = api.wkeGetTitle(win)
		set(value) = api.wkeSetWindowTitle(win, value)
	val height: Int get() = api.wkeGetHeight(win)
	val width: Int get() = api.wkeGetWidth(win)
	val contentHeight: Int
		get() = api.wkeGetContentHeight(win)
	val contentWidth: Int
		get() = api.wkeGetContentWidth(win)
	val canGoBack get() = api.wkeCanGoBack(win)
	val canGoForward get() = api.wkeCanGoForward(win)
	val url get() = api.wkeGetURL(win)
	val id get() = api.wkeGetWebviewId(win)
	//<editor-fold desc="Loading Status">
	val isDocumentReady get() = api.wkeIsDocumentReady(win)
	val isLoading get() = api.wkeIsLoading(win)
	val isLoadingFailed get() = api.wkeIsLoadingFailed(win)
	val isLoadingCompleted get() = api.wkeIsLoadingCompleted(win)
	val isLoadingSucceeded get() = api.wkeIsLoadingSucceeded(win)
	var isTransparent
		get() = api.wkeIsTransparent(win)
		set(value) = api.wkeSetTransparent(win, value)
	val document get()=jsEnv.evalReturn("document").asJsObject().asJsDocument()
	val window get()=jsEnv.evalReturn("window")
	var userAgent get() = api.wkeGetUserAgent(win)
	set(value) = api.wkeSetUserAgent(win,value)
	//</editor-fold>

	//</editor-fold>

	//<editor-fold desc="Api">
	fun load(url: String) = api.wkeLoadURL(win, url)
	fun loadFile(path: String)=api.wkeLoadFile(win,path)
	fun reload() = api.wkeReload(win)
	fun stopLoading() = api.wkeStopLoading(win)

	fun goBack() = api.wkeGoBack(win)
	fun goForward() = api.wkeGoForward(win)

	fun resize(w: Int, h: Int) = api.wkeResize(win, w, h)


	fun newWebView() = api.wkeCreateWebView().let { WebView(api, it, runtime, hwnd) }
	val cookie: Cookie?
		get() = api.wkeGetCookie(win).takeIf { it.isNotBlank() }?.let {
			it.split(";").map { it.split("=").let { it.first() to it[1] } }.toMap()
		}
	var cookieEnabled
		get() = api.wkeIsCookieEnabled(win)
		set(value) = api.wkeSetCookieEnabled(win, value)

	fun setCookie(url: String, value: Cookie?) = (value?.let { it.map { "${it.key}=${it.value}" }.joinToString("") }
		?: "").let {
		api.wkeSetCookie(win, url, it)
	}

	fun setCookieJarPath(path: String) = api.wkeSetCookieJarPath(win, path)
	fun setCookieJarFullPath(path: String) = api.wkeSetCookieJarFullPath(win, path)
	fun clearCookie() = api.wkeClearCookie(win)


	fun visitAllCookie(params: Any, visitor: (
		params: VoidPtr,
		name: String,
		value: String,
		domain: String,
		path: String,
		secure: Int,
		httpOlny: Int,
		expires: Int?
	) -> Unit) {
		api.wkeVisitAllCookie(null, object : CookieVisitor {
			override fun invoke(
				params: VoidPtr,
				name: String,
				value: String,
				domain: String,
				path: String,
				secure: Int,
				httpOlny: Int,
				expires: Int?
			) {
				visitor.invoke(params, name, value, domain, path, secure, httpOlny, expires)
			}

		})
	}

	fun setLocalStorageFullPath(path: String) = api.wkeSetLocalStorageFullPath(win, path)
	fun addPluginDirectory(path: String) = api.wkeAddPluginDirectory(win, path)

	var mediaVolume
		get() = api.wkeGetMediaVolume(win)
		set(value) = api.wkeSetMediaVolume(win, value)

	fun fireMouseEvent(msg: MouseMsg, x: Int, y: Int, flags: MouseFlags) = api.wkeFireMouseEvent(win, msg, x, y, flags)
	fun fireContextMenuEvent(x: Int, y: Int, flags: UInt) = api.wkeFireContextMenuEvent(win, x, y, flags.toInt())
	//</editor-fold>

	fun editorSelectAll() = api.wkeEditorSelectAll(win)
	fun editorUnSelect() = api.wkeEditorUnSelect(win)
	fun editorCopy() = api.wkeEditorCopy(win)
	fun editorCut() = api.wkeEditorCut(win)
	fun editorPaste() = api.wkeEditorPaste(win)
	fun editorDelete() = api.wkeEditorDelete(win)
	fun editorUndo() = api.wkeEditorUndo(win)
	fun editorRedo() = api.wkeEditorRedo(win)
	//<editor-fold desc="Hooks">
	fun onUrlChange2(callback: (WebView, url: String) -> Unit) {
		api.wkeOnURLChanged2(win, object : URLChangedCallback2 {
			override fun invoke(webView: wkeWebView, param: VoidPtr, frameId: WebFrameHandle, url: WkeString) {
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
		sourceLine: Int,
		stackTrace: String
	) -> Unit) {
		api.wkeOnConsole(win, object : ConsoleCallback {
			override fun invoke(webView: wkeWebView, param: VoidPtr, level: ConsoleLevel, message: WkeString, sourceLine: Int, stackTrace: WkeString) {
				//todo: some bug with stackTrace
				//println("trace"+stackTrace?.let { api.wkeGetString(it) })
				println("stack trace : ${stackTrace?.address()} ")
//				println("stack trace : ${stackTrace?.get()}")
				callback.invoke(
					this@WebView,
					level,
					api.wkeGetString(message),
					sourceLine,
					"" //stackTrace?.takeIf { it.address()>10000 }?.let { api.wkeGetString(it) }?:
				)
			}

		}, null)
	}

	fun onDocumentReady(callback: (WebView) -> Unit) {
		api.wkeOnDocumentReady(win, object : DocumentReadyCallback {
			override fun invoke(webView: wkeWebView, param: VoidPtr) {
				callback.invoke(this@WebView)
			}
		}, null)
	}

	fun onDocumentReady2(callback: (WebView, WebFrameHandle) -> Unit) {
		api.wkeOnDocumentReady2(win, object : DocumentReady2Callback {
			override fun invoke(webView: wkeWebView, param: VoidPtr, frameId: WebFrameHandle) {
				callback.invoke(this@WebView, frameId)
			}
		}, null)
	}
	//</editor-fold>

	//<editor-fold desc="JS">
	val jsEnv get() = Context(api, this, runtime, api.wkeGlobalExec(win)!!)

	/**
	 * script must end with return if wont fetch script result
	 * @param script String
	 * @return JsElement
	 */
	fun runJs(script: String) = api.wkeRunJS(win, script).let { JsElement(it, this.jsEnv) }
	//</editor-fold>
}
