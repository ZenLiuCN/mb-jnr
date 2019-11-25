package cn.zenliu.wke.header

import jnr.ffi.util.*


enum class WindowType : EnumMapper.IntegerEnum {
	WINDOW_TYPE_POPUP,
	WINDOW_TYPE_TRANSPARENT,
	WINDOW_TYPE_CONTROL;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class MouseFlags(val value: Int) : EnumMapper.IntegerEnum {
	LBUTTON(0x01),
	RBUTTON(0x02),
	SHIFT(0x04),
	CONTROL(0x08),
	MBUTTON(0x10);

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class KeyFlags(val value: Int) : EnumMapper.IntegerEnum {
	EXTENDED(0x0100),
	REPEAT(0x4000);

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class MouseMsg(val value: Int) : EnumMapper.IntegerEnum {
	MOUSEMOVE(0x0200),
	LBUTTONDOWN(0x0201),
	LBUTTONUP(0x0202),
	LBUTTONDBLCLK(0x0203),
	RBUTTONDOWN(0x0204),
	RBUTTONUP(0x0205),
	RBUTTONDBLCLK(0x0206),
	MBUTTONDOWN(0x0207),
	MBUTTONUP(0x0208),
	MBUTTONDBLCLK(0x0209),
	MOUSEWHEEL(0x020A);

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class ProxyType : EnumMapper.IntegerEnum {
	NONE,
	HTTP,
	SOCKS4,
	SOCKS4A,
	SOCKS5,
	SOCKS5HOSTNAME;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class SettingMask(val value: Int) : EnumMapper.IntegerEnum {
	PROXY(1),
	PAINTCALLBACK_IN_OTHER_THREAD(1 shl 2);

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class MenuItemId(val value: Int) : EnumMapper.IntegerEnum {
	MenuSelectedAllId(1 shl 1),
	MenuSelectedTextId(1 shl 2),
	MenuUndoId(1 shl 3),
	MenuCopyImageId(1 shl 4),
	MenuInspectElementAtId(1 shl 5),
	MenuCutId(1 shl 6),
	MenuPasteId(1 shl 7),
	MenuPrintId(1 shl 8),
	MenuGoForwardId(1 shl 9),
	MenuGoBackId(1 shl 10),
	MenuReloadId(1 shl 11);

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class CookieCommand : EnumMapper.IntegerEnum {
	ClearAllCookies,
	ClearSessionCookies,
	FlushCookiesToFile,
	ReloadCookiesFromFile;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class NavigationType : EnumMapper.IntegerEnum {
	LINKCLICK,
	FORMSUBMITTE,
	BACKFORWARD,
	RELOAD,
	FORMRESUBMITT,
	OTHER;


	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class CursorInfoType : EnumMapper.IntegerEnum {
	Pointer,
	Cross,
	Hand,
	IBeam,
	Wait,
	Help,
	EastResize,
	NorthResize,
	NorthEastResize,
	NorthWestResize,
	SouthResize,
	SouthEastResize,
	SouthWestResize,
	WestResize,
	NorthSouthResize,
	EastWestResize,
	NorthEastSouthWestResize,
	NorthWestSouthEastResize,
	ColumnResize,
	RowResize,
	MiddlePanning,
	EastPanning,
	NorthPanning,
	NorthEastPanning,
	NorthWestPanning,
	SouthPanning,
	SouthEastPanning,
	SouthWestPanning,
	WestPanning,
	Move,
	VerticalText,
	Cell,
	ContextMenu,
	Alias,
	Progress,
	NoDrop,
	Copy,
	None,
	NotAllowed,
	ZoomIn,
	ZoomOut,
	Grab,
	Grabbing,
	Custom;


	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class StorageType : EnumMapper.IntegerEnum {
	// String data with an associated MIME type. Depending on the MIME type, there may be
	// optional metadata attributes as well.
	String,
	// Stores the name of one file being dragged into the renderer.
	Filename,
	// An image being dragged out of the renderer. Contains a buffer holding the image data
	// as well as the suggested name for saving the image to.
	BinaryData,
	// Stores the filesystem URL of one file being dragged into the renderer.
	FileSystemFile;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class WebDragOperation(val value: Long) {
	None(0),
	Copy(1),
	Link(2),
	Generic(4),
	Private(8),
	Move(16),
	Delete(32),
	Every(0xffffffff);

	//	override fun intValue() = value.toInt()
	fun longValue() = value

	companion object {
		fun from(ord: Long) = values().find { it.value == ord }
	}
}

enum class ResourceType(val value: Int) : EnumMapper.IntegerEnum {
	WKE_RESOURCE_TYPE_MAIN_FRAME(0),       // top level page
	WKE_RESOURCE_TYPE_SUB_FRAME(1),        // frame or iframe
	WKE_RESOURCE_TYPE_STYLESHEET(2),       // a CSS stylesheet
	WKE_RESOURCE_TYPE_SCRIPT(3),           // an external script
	WKE_RESOURCE_TYPE_IMAGE(4),            // an image (jpg/gif/png/etc)
	WKE_RESOURCE_TYPE_FONT_RESOURCE(5),    // a font
	WKE_RESOURCE_TYPE_SUB_RESOURCE(6),     // an "other" subresource.
	WKE_RESOURCE_TYPE_OBJECT(7),           // an object (or embed) tag for a plugin,
	// or a resource that a plugin requested.
	WKE_RESOURCE_TYPE_MEDIA(8),            // a media resource.
	WKE_RESOURCE_TYPE_WORKER(9),           // the main resource of a dedicated
	// worker.
	WKE_RESOURCE_TYPE_SHARED_WORKER(10),   // the main resource of a shared worker.
	WKE_RESOURCE_TYPE_PREFETCH(11),       // an explicitly requested prefetch
	WKE_RESOURCE_TYPE_FAVICON(12),        // a favicon
	WKE_RESOURCE_TYPE_XHR(13),            // a XMLHttpRequest
	WKE_RESOURCE_TYPE_PING(14),           // a ping request for <a ping>
	WKE_RESOURCE_TYPE_SERVICE_WORKER(15),  // the main resource of a service worker.
	WKE_RESOURCE_TYPE_LAST_TYPE(11);

	override fun intValue() = value

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class OnContextMenuItemClickType(val value: Int) : EnumMapper.IntegerEnum {
	kWkeContextMenuItemClickTypePrint(0x01);

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().find { it.value == ord }
	}
}

enum class HttBodyElementType : EnumMapper.IntegerEnum {
	wkeHttBodyElementTypeData,
	wkeHttBodyElementTypeFile;

	override fun intValue() = ordinal


	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class RequestType : EnumMapper.IntegerEnum {
	Invalidation,
	Get,
	Post,
	Put;


	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class OtherLoadType : EnumMapper.IntegerEnum {
	WKE_DID_START_LOADING,
	WKE_DID_STOP_LOADING,
	WKE_DID_NAVIGATE,
	WKE_DID_NAVIGATE_IN_PAGE,
	WKE_DID_GET_RESPONSE_DETAILS,
	WKE_DID_GET_REDIRECT_REQUEST,
	WKE_DID_POST_REQUEST;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class LoadingResult : EnumMapper.IntegerEnum {
	WKE_LOADING_SUCCEEDED,
	WKE_LOADING_FAILED,
	WKE_LOADING_CANCELED;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class DownloadOpt : EnumMapper.IntegerEnum {
	kWkeDownloadOptCancel,
	kWkeDownloadOptCacheData;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class OnContextMenuItemClickStep(val value: Int) : EnumMapper.IntegerEnum {
	Show(0x01),
	Click(0x02);

	override fun intValue() = value

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class ConsoleLevel(val value: Int) : EnumMapper.IntegerEnum {
	wkeLevelDebug(4),
	wkeLevelLog(1),
	wkeLevelInfo(5),
	wkeLevelWarning(2),
	wkeLevelError(3),
	wkeLevelRevokedError(6),
	wkeLevelLast(5);

	override fun intValue() = value

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}

enum class JsType : EnumMapper.IntegerEnum {
	NUMBER,
	STRING,
	BOOLEAN,
	OBJECT,
	FUNCTION,
	UNDEFINED,
	ARRAY,
	NULL;

	override fun intValue() = ordinal

	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
}
