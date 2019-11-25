package cn.zenliu.wke.header

import jnr.ffi.*
import jnr.ffi.annotations.*
import jnr.ffi.types.*
import java.nio.*

interface FILE_OPEN {
	@Delegate
	fun invoke(path: String): VoidPtr
}

interface FILE_CLOSE {
	@Delegate
	fun invoke(file: VoidPtr)
}

interface FILE_SIZE {
	@Delegate
		/**
		 *
		 * @param file Pointer
		 * @return Long
		 * @see @size_t
		 */
	@size_t
	fun invoke(file: VoidPtr): Long
}

interface FILE_READ {
	@Delegate
	fun invoke(file: VoidPtr, @In buffer: StringBuffer, @size_t size: Long): Int
}

interface FILE_SEEK {
	@Delegate
	fun invoke(file: VoidPtr, offset: Int, origin: Int): Int
}

interface EXISTS_FILE {
	@Delegate
	fun invoke(path: String): Boolean
}

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
		navigationType: NavigationType
	)
}

interface CreateViewCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		navigationType: NavigationType,
		url: WkeString,
		windowFeatures: WindowFeatures?
	)
}

interface DocumentReadyCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr
	)
}

interface DocumentReady2Callback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle
	)
}

interface OnShowDevtoolsCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr
	)
}

interface NodeOnCreateProcessCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		applicationPath: String,//todo??
		arguments: String,//WCHAR??
		startup: STARTUPINFOW
	)
}

interface OnPluginFindCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		mime: String,//todo?? utf8*
		initializeFunc: VoidPtr,
		getEntryPointsFunc: VoidPtr,
		shutdownFunc: VoidPtr
	)
}

interface OnPrintCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle,
		printParams: VoidPtr
	)
}

interface OnScreenshot {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		data: String,
		@size_t
		size: Long
	)
}
typealias ImageBufferToDataURL = OnScreenshot
typealias ConfirmBoxCallback = AlertBoxCallback

interface WillMediaLoadCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url: String,
		info: MediaLoadInfo?
	)
}

interface StartDraggingCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frame: WebFrameHandle,
		data: DragData,
		mask: WebDragOperationsMask,
		image: VoidPtr,
		dragImageOffset: Point
	)
}

interface UiThreadRunCallback {
	@Delegate
	fun invoke(
		hwnd: HWND,
		param: VoidPtr
	)
}

interface UiThreadPostTaskCallback {
	@Delegate
	fun invoke(
		hwnd: HWND,
		callback: UiThreadRunCallback,
		param: VoidPtr
	)
}

interface OnOtherLoadCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		type: OtherLoadType,//OtherLoadType
		info: TempCallbackInfo?
	)
}

interface OnContextMenuItemClickCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		type: OnContextMenuItemClickType,
		step: OnContextMenuItemClickStep,
		frameId: wkeWebFrameHandle,
		info: TempCallbackInfo?
	): Boolean
}

interface NetJobDataRecvCallback {
	@Delegate
	fun invoke(
		ptr: VoidPtr,
		job: NetJob,
		data: ByteBuffer,
		length: Int
	)
}

interface NetJobDataFinishCallback {
	@Delegate
	fun invoke(
		ptr: VoidPtr,
		job: NetJob,
		result: LoadingResult
	)
}

interface LoadingFinishCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url: WkeString,
		result: LoadingResult,
		failedReasone: WkeString
	)
}

interface DownloadCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url: WkeString
	)
}

interface Download2Callback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		@size_t expectedContentLength: Long,
		url: String,
		mime: String,
		disposition: String,
		job: NetJob,
		dataBind: NetJobDataBind
	)
}

interface ConsoleCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		level: ConsoleLevel,
		message: WkeString,
		@u_int32_t
		sourceLine: Int,
		stackTrace: WkeString
	)
}


interface OnCallUiThread {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		paramOnInThread: VoidPtr
	):Unit
}


interface CallUiThread {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		func: OnCallUiThread,
		param: VoidPtr
	)
}
interface MediaPlayerFactory {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		client:MediaPlayerClient,
		npBrowserFuncs: VoidPtr,
		npPluginFuncs: VoidPtr
	):MediaPlayer
}

interface WindowClosingCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr
	):Boolean
}
interface WindowDestroyCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr
	):Boolean
}
interface NetResponseCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url:String,
		job:NetJob
	):Boolean
}
interface OnNetGetFaviconCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url:String,
		buf:MemBuf?
	):Boolean
}
interface LoadUrlBeginCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url:String,
		job:NetJob
	):Boolean
}
interface LoadUrlFailCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url:String,
		job:NetJob
	)
}
interface LoadUrlEndCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		url:String,
		job:NetJob,
		buf:VoidPtr,
		len:Int
	)
}

interface DidCreateScriptContextCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle,
		context:VoidPtr,
		extensionGroup:Int,
		worldId:Int
	)
}
interface WillReleaseScriptContextCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		frameId: WebFrameHandle,
		context:VoidPtr,
		extensionGroup:Int,
		worldId:Int
	)
}
interface DraggableRegionsChangedCallback {
	@Delegate
	fun invoke(
		webView: wkeWebView,
		param: VoidPtr,
		rects: Pointer,//DraggableRegion,
		rectCount:Int
	)
}

interface JsGetPropertyCallback {@Delegate fun invoke(
		es: JsExecState,
		obj: JsValue,
		propertyName:String
	):JsValue}

interface JsSetPropertyCallback {@Delegate fun invoke(
	es: JsExecState,
	obj: JsValue,
	propertyName:String,
	value:JsValue
):Boolean}
interface JsCallAsFunctionCallback {@Delegate fun invoke(
	es: JsExecState,
	obj: JsValue,
	args:Pointer,//*JsValue
	argCount:Int
):Boolean}

interface JsFinalizeCallback {@Delegate fun invoke(
	data:JsData
)}
interface OnUrlRequestWillRedirectCallback {@Delegate fun invoke(
	webView: wkeWebView,
	param: VoidPtr,
	oldRequest:WebUrlRequestPtr,
	request:WebUrlRequestPtr,
	redirectResponse:WebUrlResponsePtr
)}
interface OnUrlRequestDidReceiveResponseCallback {@Delegate fun invoke(
	webView: wkeWebView,
	param: VoidPtr,
	request:WebUrlRequestPtr,
	redirectResponse:WebUrlResponsePtr
)}

interface OnUrlRequestDidReceiveDataCallback {@Delegate fun invoke(
	webView: wkeWebView,
	param: VoidPtr,
	request:WebUrlRequestPtr,
	data:Buffer,
	dataLength:Int
)}
interface OnUrlRequestDidFailCallback {@Delegate fun invoke(
	webView: wkeWebView,
	param: VoidPtr,
	request:WebUrlRequestPtr,
	error:String
)}

interface OnUrlRequestDidFinishLoadingCallback {@Delegate fun invoke(
	webView: wkeWebView,
	param: VoidPtr,
	request:WebUrlRequestPtr,
	finishTime:Double
)}

interface JsNativeFunction{
	@Delegate
	fun invoke(es:JsExecState):JsValue
}
interface wkeJsNativeFunction{
	@Delegate
	fun invoke(es:JsExecState,param: VoidPtr):JsValue
}
