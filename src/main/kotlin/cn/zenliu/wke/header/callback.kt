package cn.zenliu.wke.header

import jnr.ffi.*
import jnr.ffi.annotations.*
import jnr.ffi.types.*


interface ON_TITLE_CHANGED {
	@Delegate
	fun invoke(clientHandler: ClientHandler, title: WkeString)
}
interface ON_URL_CHANGED {
	@Delegate
	fun invoke(clientHandler: ClientHandler, url: WkeString)
}
interface CookieVisitor {
	@Delegate
	fun invoke(
		params: VoidPtr,
		name: String,
		value: String,
		domain: String,
		path: String,
		secure: Int,
		httpOlny: Int,
		expires: Int?
	): Boolean
}
interface TitleChangedCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		title: WkeString
	)
}
interface URLChangedCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url: WkeString
	)
}
interface URLChangedCallback2 {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle,
		url: WkeString
	)
}
interface PaintUpdatedCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		hdc: HDC,
		x: Int,
		y: Int,
		cx: Int,
		cy: Int
	)
}
interface PaintBitUpdatedCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		buffer: VoidPtr,
		r: Rect?,
		w: Int,
		h: Int
	)
}
interface AlertBoxCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		msg: WkeString
	)
}
interface PromptBoxCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		msg: WkeString,
		defualt: WkeString,
		result: WkeString
	)
}
interface NavigationCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		navigationType: Int
	)
}
interface CreateViewCallback{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		navigationType: Int,
		url: WkeString,
		windowFeatures: WindowFeatures?
	)
}
interface DocumentReadyCallback{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr
	)
}
interface DocumentReadyCallback2{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle
	)
}
interface OnShowDevtoolsCallback{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr
	)
}
interface NodeOnCreateProcessCallback{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		applicationPath:String,//todo??
		arguments:String,//WCHAR??
		startup: STARTUPINFOW
	)
}
interface OnPluginFindCallback{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		mime:String,//todo?? utf8*
		initializeFunc: VoidPtr,
		getEntryPointsFunc: VoidPtr,
		shutdownFunc: VoidPtr
	)
}
interface OnPrintCallback{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle,
		printParams: VoidPtr
	)
}
interface OnScreenshot{
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		data:String,
		@size_t
		size:Long
	)
}
typealias ImageBufferToDataURL= OnScreenshot
typealias ConfirmBoxCallback= AlertBoxCallback
