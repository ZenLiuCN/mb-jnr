package cn.zenliu.wke.header

import jnr.ffi.*


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
	val resourceType: Int,
	val httpResponseCode: Int,
	val method: WkeString,
	val referrer: WkeString,
	val headers: jnr.ffi.Pointer,
	runtime: Runtime
) : Struct(runtime)


class PostBodyElement(
	val size: Int,
	val type: Int,//HttBodyElementType
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
