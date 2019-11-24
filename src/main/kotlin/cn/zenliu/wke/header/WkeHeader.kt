package cn.zenliu.wke.header

import jnr.ffi.*
import jnr.ffi.annotations.*
import jnr.ffi.types.*




typealias wkeWebView = Pointer
typealias wkeWindowType = Int
typealias ptrWkeProxy = Pointer
typealias PtrwkeSettings = Pointer
typealias jsExceptionInfoPtr = Pointer
typealias jsNativeFunction = Pointer
typealias jsKeysPtr = Pointer
typealias jsDataPtr = Pointer
typealias jsValuePtr = Pointer
typealias wkeOnNetGetFaviconCallback = Pointer
typealias wkeMemBufPtr = Pointer
typealias wkeRequestType = Pointer
typealias PtrwkePostBodyElements = Pointer
typealias jsType = Pointer
typealias LRESULT = Pointer
//typealias wkeRect = Pointer
typealias jsValue = Pointer

typealias wkeTitleChangedCallback = Pointer

//typealias wkeURLChangedCallback2 = Pointer
interface wkeURLChangedCallback2 {
	@Delegate
	fun invoke(webView: wkeWebView, param: Pointer?, frameId: wkeWebFrameHandle, url: wkeString)
}

typealias wkeURLChangedCallback = Pointer
typealias wkePaintUpdatedCallback = Pointer
typealias wkeWindowClosingCallback = Pointer
typealias wkeWindowDestroyCallback = Pointer
typealias wkePaintBitUpdatedCallback = Pointer
typealias wkeAlertBoxCallback = Pointer
typealias wkeConfirmBoxCallback = Pointer
typealias wkePromptBoxCallback = Pointer
typealias wkeNavigationCallback = Pointer
typealias wkeCreateViewCallback = Pointer
typealias wkeDocumentReadyCallback = Pointer
typealias wkeDocumentReady2Callback = Pointer
typealias wkeDownloadCallback = Pointer
typealias wkeNetResponseCallback = Pointer
typealias wkeConsoleCallback = Pointer
typealias wkeCallUiThread = Pointer
typealias wkeLoadUrlBeginCallback = Pointer
typealias wkeLoadUrlEndCallback = Pointer
typealias wkeDidCreateScriptContextCallback = Pointer
typealias wkeWillReleaseScriptContextCallback = Pointer
typealias wkeWillMediaLoadCallback = Pointer
typealias wkeString = Pointer

typealias wkeWebFrameHandle = Pointer

typealias WCHAR_T = String

typealias UINT = Int
typealias LPARAM = Int
typealias WPARAM = Int
