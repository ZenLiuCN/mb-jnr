package cn.zenliu.wke.header

import jnr.ffi.Struct
import jnr.ffi.Runtime
import jnr.ffi.annotations.*
import jnr.ffi.types.*


class Rect(
	val x: Int,
	val y: Int,
	val w: Int,
	val h: Int,
	runtime: Runtime
) : Struct(runtime)

class Point(
	val x: Int,
	val y: Int,
	runtime: Runtime
) : Struct(runtime)

class Proxy(
	val hostName: String,
	val port: Int,
	val username: String,
	val password: String,
	runtime: Runtime
) : Struct(runtime)

class Settings(
	val proxy: Proxy,
	val mask: Int,
	runtime: Runtime
) : Struct(runtime)

class ViewSettings(
	val size: Int,
	val bgColor: Int,
	runtime: Runtime
) : Struct(runtime)

class GeolocationPosition(
	val timestamp: Double,
	val latitude: Double,
	val longitude: Double,
	val accuracy: Double,
	val providesAltitude: Boolean,
	val altitude: Double,
	val providesAltitudeAccuracy: Boolean,
	val altitudeAccuracy: Double,
	val providesHeading: Boolean,
	val heading: Double,
	val providesSpeed: Boolean,
	val speed: Double,
	runtime: Runtime
) : Struct(runtime)

class ClientHandler(
	val onTitleChanged: ON_TITLE_CHANGED,
	val onURLChanged: ON_URL_CHANGED,
	runtime: Runtime
) : Struct(runtime)


class WindowFeatures(
	val x: Int,
	val y: Int,
	val width: Int,
	val height: Int,

	val menuBarVisible: Boolean,
	val statusBarVisible: Boolean,
	val toolBarVisible: Boolean,
	val locationBarVisible: Boolean,
	val scrollbarsVisible: Boolean,
	val resizable: Boolean,
	val fullscreen: Boolean,
	runtime: Runtime
) : Struct(runtime)

class MemBuf(
	val size: Int,
	val dat: Pointer,
	@jnr.ffi.types.size_t
	val length: Long,
	runtime: Runtime
) : Struct(runtime)

class Item(
	val stringType: MemBuf?,
	val stringData: MemBuf?,
	val filenameData: MemBuf?,
	val displayNameData: MemBuf?,
	val binaryData: MemBuf?,
	val title: MemBuf?,
	val fileSystemURL: MemBuf?,
	@jnr.ffi.types.int64_t
	val fileSystemFileSize: Long,
	val baseURL: MemBuf?,
	runtime: Runtime
) : Struct(runtime)

class DragData(
	val itemList: Array<Item>,
	val itemListLength: Int,
	val modifireKeyState: Int,
	val fileSystemId: MemBuf?,
	runtime: Runtime
) : Struct(runtime)


class WillSendRequestInfo(
	val url: WkeString,
	val newUrl: WkeString,
	val resourceType: ResourceType,
	val httpResponseCode: Int,
	val method: WkeString,
	val referrer: WkeString,
	val headers: jnr.ffi.Pointer,
	runtime: Runtime
) : Struct(runtime)


class PostBodyElement(
	val size: Int,
	val type: HttBodyElementType,//HttBodyElementType
	val dat: MemBuf?,
	val filePath: WkeString,
	@jnr.ffi.types.int64_t
	val fileStart: Long,
	@jnr.ffi.types.int64_t
	val fileLength: Long, // -1 means to the end of the file.
	runtime: Runtime
) : Struct(runtime)

class PostBodyElements(
	val size: Int,
	val element: Array<PostBodyElement>,
	@jnr.ffi.types.size_t
	val elementSize: Long,
	val isDirty: Boolean,
	runtime: Runtime
) : Struct(runtime)

class Slist(
	@In
	val data: ByteArray,
	val next: Slist?,
	runtime: Runtime
) : Struct(runtime)

class TempCallbackInfo(
	val size: Int,
	val willSendRequestInfo: WillSendRequestInfo,
	val url: String,
	val postBody: PostBodyElements?,
	val job: NetJob,
	runtime: Runtime
) : Struct(runtime)

class PrintSettings(
	val structSize: Int,
	val dpi: Int,
	val width: Int, // in px
	val height: Int,
	val marginTop: Int,
	val marginBottom: Int,
	val marginLeft: Int,
	val marginRight: Int,
	val isPrintPageHeadAndFooter: Boolean,
	val isPrintBackgroud: Boolean,
	val isLandscape: Boolean,
	runtime: Runtime
) : Struct(runtime)

class ScreenshotSettings(
	val structSize: Int,
	val width: Int,
	val height: Int,
	runtime: Runtime
) : Struct(runtime)

class MediaLoadInfo(
	val size: Int,
	val width: Int,
	val height: Int,
	val duration: Double,
	runtime: Runtime
) : Struct(runtime)

class NetJobDataBind(
	val param: VoidPtr,
	val recvCallback: NetJobDataRecvCallback,
	val finishCallback: NetJobDataFinishCallback,
	runtime: Runtime
) : Struct(runtime)

class WindowCreateInfo(
	val size: Int,
	val parent: HWND,
	val style: Struct.DWORD,
	val styleEx: Struct.DWORD,
	val x: Int,
	val y: Int,
	val width: Int,
	val height: Int,
	val color: COLORREF,
	runtime: Runtime
) : Struct(runtime)

class DraggableRegion(
	val bounds: Rect,
	val draggable: Boolean,
	runtime: Runtime
) : Struct(runtime)

class JsData(
	val typeName: CharArray,
	val propertyGet: JsGetPropertyCallback,
	val propertySet: JsSetPropertyCallback,
	val finalize: JsFinalizeCallback,
	val callAsFunction: JsCallAsFunctionCallback,
	runtime: Runtime
) : Struct(runtime)

class JsExceptionInfo(
	val message: String, // Returns the exception message.
	val sourceLine: String, // Returns the line of source code that the exception occurred within.
	val scriptResourceName: String, // Returns the resource name for the script from where the function causing the error originates.
	val lineNumber: Int, // Returns the 1-based number of the line where the error occurred or 0 if the line number is unknown.
	val startPosition: Int, // Returns the index within the script of the first character where the error occurred.
	val endPosition: Int, // Returns the index within the script of the last character where the error occurred.
	val startColumn: Int, // Returns the index within the line of the first character where the error occurred.
	val endColumn: Int, // Returns the index within the line of the last character where the error occurred.
	val callstackString: String,
	runtime: Runtime
) : Struct(runtime)
class JsKeys (
	@jnr.ffi.types.u_int32_t
	val length:Int,
	val keys:VoidPtr,//const char**
	runtime: Runtime
) : Struct(runtime)
class UrlRequestCallbacks (
	val willRedirectCallback:OnUrlRequestWillRedirectCallback,
	val didReceiveResponseCallback:OnUrlRequestDidReceiveResponseCallback,
	val didReceiveDataCallback:OnUrlRequestDidReceiveDataCallback,
	val didFailCallback:OnUrlRequestDidFailCallback,
	val didFinishLoadingCallback:OnUrlRequestDidFinishLoadingCallback,
	runtime: Runtime
) : Struct(runtime)
