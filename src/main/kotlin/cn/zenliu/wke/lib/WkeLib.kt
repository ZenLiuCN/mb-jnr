package cn.zenliu.wke.lib

import cn.zenliu.wke.header.*
import jnr.ffi.*
import jnr.ffi.annotations.*
import jnr.ffi.types.*


interface WkeLib {

	fun wkeVersion(): Int
	fun wkeVersionString(): String
	fun wkeSetWkeDllPath(dllPath: String)
	fun wkeGC(webView: wkeWebView, delayMs: Long)

	//	5
	fun wkeSetFileSystem(pfnOpen: FILE_OPEN, pfnClose: FILE_CLOSE, pfnSize: FILE_SIZE, pfnRead: FILE_READ, pfnSeek: FILE_SEEK)

	fun wkeIsDocumentReady(webView: wkeWebView): Boolean

	fun wkeStopLoading(webView: wkeWebView)
	fun wkeReload(webView: wkeWebView): Boolean
	fun wkeGetTitle(webView: wkeWebView): String
	fun wkeGetTitleW(webView: wkeWebView): WCHAR_T
	fun wkeResize(webView: wkeWebView, w: Int, h: Int)

	//16
	fun wkeGetWidth(webView: wkeWebView): Int

	//17
	fun wkeGetHeight(webView: wkeWebView): Int

	//18
	fun wkeGetContentWidth(webView: wkeWebView): Int

	//19
	fun wkeGetContentHeight(webView: wkeWebView): Int

	//24
	fun wkePaint2(webView: wkeWebView, bits: Pointer, bufWid: Int, bufHei: Int, xDst: Int, yDst: Int, w: Int, h: Int, xSrc: Int, ySrc: Int, bCopyAlpha: Boolean)

	//25
	fun wkePaint(webView: wkeWebView, bits: Pointer, pitch: Int)

	//27
	fun wkeGetViewDC(webView: wkeWebView): HDC//HDC

	//28
	fun wkeGetHostHWND(webView: wkeWebView): HWND//HWND

	//29
	fun wkeCanGoBack(webView: wkeWebView): Boolean

	//30
	fun wkeGoBack(webView: wkeWebView): Boolean

	//31
	fun wkeCanGoForward(webView: wkeWebView): Boolean

	//32
	fun wkeGoForward(webView: wkeWebView): Boolean

	//33
	fun wkeEditorSelectAll(webView: wkeWebView)

	//34
	fun wkeEditorUnSelect(webView: wkeWebView)

	//35
	fun wkeEditorCopy(webView: wkeWebView)

	//36
	fun wkeEditorCut(webView: wkeWebView)

	//37
	fun wkeEditorDelete(webView: wkeWebView)

	//38
	fun wkeEditorUndo(webView: wkeWebView)

	//39
	fun wkeEditorRedo(webView: wkeWebView)

	//40
	fun wkeGetCookieW(webView: wkeWebView): String //const wchar_t *

	//41
	fun wkeGetCookie(webView: wkeWebView): String

	//42
	fun wkeSetCookie(webView: wkeWebView, url: String, cookie: String)

	//43
	fun wkeVisitAllCookie(params: Pointer, visitor: Pointer)//wkeCookieVisitor

	//44
	fun wkePerformCookieCommand(webView: wkeWebView, command: Pointer)//wkeCookieCommand

	//45
	fun wkeSetCookieEnabled(webView: wkeWebView, enable: Boolean)

	//46
	fun wkeIsCookieEnabled(webView: wkeWebView): Boolean

	//47
	fun wkeSetCookieJarPath(webView: wkeWebView, path: String) //const WCHAR*

	//48
	fun wkeSetCookieJarFullPath(webView: wkeWebView, path: String) //const WCHAR*

	//49
	fun wkeSetLocalStorageFullPath(webView: wkeWebView, path: String) //const WCHAR*

	//50
	fun wkeSetMediaVolume(webView: wkeWebView, volume: Float)

	//51
	fun wkeGetMediaVolume(webView: wkeWebView): Float

	//52
	fun wkeFireMouseEvent(webView: wkeWebView, message: UINT, x: Int, y: Int, flags: UINT): Boolean

	//53
	fun wkeFireContextMenuEvent(webView: wkeWebView, x: Int, y: Int, flags: UINT): Boolean

	//54
	fun wkeFireMouseWheelEvent(webView: wkeWebView, x: Int, y: Int, delta: Int, flags: UINT): Boolean

	//55
	fun wkeFireKeyUpEvent(webView: wkeWebView, virtualKeyCode: UINT, flags: UINT, systemKey: Boolean): Boolean

	//56
	fun wkeFireKeyDownEvent(webView: wkeWebView, virtualKeyCode: UINT, flags: UINT, systemKey: Boolean): Boolean

	//57
	fun wkeFireWindowsMessage(webView: wkeWebView, hWnd: HWND, message: UINT, wParam: WPARAM, lParam: LPARAM, result: LRESULT): Boolean

	//58
	fun wkeSetFocus(webView: wkeWebView)

	//59
	fun wkeKillFocus(webView: wkeWebView)

	//60
	fun wkeGetCaretRect(webView: wkeWebView): Rect

	//61
	fun wkeRunJS(webView: wkeWebView, script: String): JsValue

	//62
	fun wkeRunJSW(webView: wkeWebView, script: WCHAR_T): JsValue

	//63
	fun wkeGlobalExec(webView: wkeWebView): JsExecState

	//64
	fun wkeSleep(webView: wkeWebView)

	//65
	fun wkeWake(webView: wkeWebView)

	//66
	fun wkeIsAwake(webView: wkeWebView): Boolean

	//67
	fun wkeSetZoomFactor(webView: wkeWebView, factor: Float)

	//68
	fun wkeGetZoomFactor(webView: wkeWebView): Float

	//69
	fun wkeSetEditable(webView: wkeWebView, editable: Boolean)

	//70
	fun wkeOnTitleChanged(webView: wkeWebView, callback: TitleChangedCallback, callbackParam: Pointer?)

	//71
	fun wkeOnMouseOverUrlChanged(webView: wkeWebView, callback: TitleChangedCallback, callbackParam: Pointer?)

	//72
	fun wkeOnURLChanged(webView: wkeWebView, callback: URLChangedCallback, callbackParam: Pointer??)

	//73
	fun wkeOnURLChanged2(webView: wkeWebView, callback: URLChangedCallback2, callbackParam: Pointer??)

	//75
	fun wkeOnPaintUpdated(webView: wkeWebView, callback: PaintUpdatedCallback, callbackParam: Pointer?)

	//77
	fun wkeOnPaintBitUpdated(webView: wkeWebView, callback: PaintBitUpdatedCallback, callbackParam: Pointer?)

	//78
	fun wkeOnAlertBox(webView: wkeWebView, callback: AlertBoxCallback, callbackParam: Pointer?)

	//79
	fun wkeOnConfirmBox(webView: wkeWebView, callback: ConfirmBoxCallback, callbackParam: Pointer?)

	//80
	fun wkeOnPromptBox(webView: wkeWebView, callback: PromptBoxCallback, callbackParam: Pointer?)

	//81
	fun wkeOnNavigation(webView: wkeWebView, callback: NavigationCallback, callbackParam: Pointer?)

	//83
	fun wkeOnCreateView(webView: wkeWebView, callback: CreateViewCallback, callbackParam: Pointer?)

	//85
	fun wkeOnDocumentReady(webView: wkeWebView, callback: DocumentReadyCallback, callbackParam: Pointer??)

	//86
	fun wkeOnDocumentReady2(webView: wkeWebView, callback: DocumentReady2Callback, callbackParam: Pointer?)

	//87
	fun wkeOnDownload(webView: wkeWebView, callback: DownloadCallback, callbackParam: Pointer?)

	//88
	fun wkeNetOnResponse(webView: wkeWebView, callback: NetResponseCallback, callbackParam: Pointer?)

	//89
	fun wkeOnConsole(webView: wkeWebView, callback: ConsoleCallback, callbackParam: Pointer?)

	//90
	fun wkeSetUIThreadCallback(webView: wkeWebView, callback: CallUiThread, callbackParam: Pointer?)

	//91
	fun wkeOnLoadUrlBegin(webView: wkeWebView, callback: LoadUrlBeginCallback, callbackParam: Pointer?)

	//92
	fun wkeOnLoadUrlEnd(webView: wkeWebView, callback: LoadUrlEndCallback, callbackParam: Pointer?)

	//93
	fun wkeOnDidCreateScriptContext(webView: wkeWebView, callback: DidCreateScriptContextCallback, callbackParam: Pointer?)

	//94
	fun wkeOnWillReleaseScriptContext(webView: wkeWebView, callback: WillReleaseScriptContextCallback, callbackParam: Pointer?)

	//95
	fun wkeOnWillMediaLoad(webView: wkeWebView, callback: WillMediaLoadCallback, callbackParam: Pointer?)

	//96
	fun wkeIsMainFrame(webView: wkeWebView, frameId: wkeWebFrameHandle): Boolean

	//97
	fun wkeWebFrameGetMainFrame(webView: wkeWebView): wkeWebFrameHandle

	//98
	fun wkeRunJsByFrame(webView: wkeWebView, frameId: wkeWebFrameHandle, script: String, isInClosure: Boolean): JsValue

	//99
	fun wkeGetFrameUrl(webView: wkeWebView, frameId: wkeWebFrameHandle): String

	//100
	fun wkeGetString(s: WkeString): String

	//101
	fun wkeGetStringW(string: WkeString): WCHAR_T

	//102
	fun wkeSetString(string: WkeString, str: String, @size_t len: Long)

	//103
	fun wkeSetStringW(string: WkeString, str: WCHAR_T, @size_t len: Long)

	//104
	fun wkeCreateStringW(str: WCHAR_T, @size_t len: Long): WkeString

	//105
	fun wkeDeleteString(str: WkeString)

	//106
	fun wkeSetUserKeyValue(webView: wkeWebView, key: String, value: Pointer)

	//107
	fun wkeGetUserKeyValue(webView: wkeWebView, key: String): Pointer

	//108
	fun wkeGetCursorInfoType(webView: wkeWebView): Int

	//109
	fun wkeCreateWebView(): wkeWebView

	//110
	fun wkeDestroyWebView(webView: wkeWebView)

	//111
	fun wkeCreateWebWindow(type: WindowType, parent: HWND?, x: Int, y: Int, width: Int, height: Int): wkeWebView

	//112
	fun wkeDestroyWebWindow(webWindow: wkeWebView)

	//113
	fun wkeGetWindowHandle(webWindow: wkeWebView): HWND

	//114
	fun wkeOnWindowClosing(webWindow: wkeWebView, callback: WindowClosingCallback, param: Pointer)

	//115
	fun wkeOnWindowDestroy(webWindow: wkeWebView, callback: WindowDestroyCallback, param: Pointer)

	//116
	fun wkeShowWindow(webWindow: wkeWebView, showFlag: Boolean)

	//117
	fun wkeEnableWindow(webWindow: wkeWebView, enableFlag: Boolean)

	//118
	fun wkeMoveWindow(webWindow: wkeWebView, x: Int, y: Int, width: Int, height: Int)

	//119
	fun wkeMoveToCenter(webWindow: wkeWebView)

	//120
	fun wkeResizeWindow(webWindow: wkeWebView, width: Int, height: Int)

	//121
	fun wkeSetWindowTitle(webWindow: wkeWebView, title: String)

	//122 !! ?
	fun wkeSetWindowTitleW(webWindow: wkeWebView, itle: WCHAR_T)

	//123
	fun wkeSetDeviceParameter(webView: wkeWebView, device: String, paramStr: String, paramInt: Int, paramFloat: Float)

	//124
	fun wkeInit()

	//126
	fun wkeInitialize()

	//127
	fun wkeSetProxy(proxy: ptrWkeProxy)

	//128
	fun wkeSetViewProxy(webView: wkeWebView, proxy: ptrWkeProxy)

	//129
	fun wkeConfigure(settings: PtrwkeSettings)

	//130
	fun wkeIsInitialize(): Boolean

	//132
	fun wkeSetMemoryCacheEnable(webView: wkeWebView, b: Boolean)

	//133
	fun wkeSetTouchEnabled(webView: wkeWebView, b: Boolean)

	//134
	fun wkeSetMouseEnabled(webView: wkeWebView, b: Boolean)

	//135
	fun wkeSetNavigationToNewWindowEnable(webView: wkeWebView, b: Boolean)

	//136
	fun wkeSetCspCheckEnable(webView: wkeWebView, b: Boolean)

	//137
	fun wkeSetNpapiPluginsEnabled(webView: wkeWebView, b: Boolean)

	//138
	fun wkeSetHeadlessEnabled(webView: wkeWebView, b: Boolean)

	//139
	fun wkeSetDebugConfig(webView: wkeWebView, debugString: String, param: String)

	//140
	fun wkeSetHandle(webView: wkeWebView, wnd: HWND)

	//141
	fun wkeSetHandleOffset(webView: wkeWebView, x: Int, y: Int)

	//142
	fun wkeSetViewSettings(webView: wkeWebView, settings: PtrwkeSettings)

	//143
	fun wkeSetTransparent(webView: wkeWebView, transparent: Boolean)

	//144
	fun wkeIsTransparent(webView: wkeWebView): Boolean

	//145
	fun wkeSetUserAgent(webView: wkeWebView, userAgent: String)

	//146
	fun wkeSetUserAgentW(webView: wkeWebView, userAgent: WCHAR_T)

	//147
	fun wkeGetUserAgent(webView: wkeWebView): String

	//148
	fun wkeLoadURL(webView: wkeWebView, url: String)

	//149
	fun wkeLoadW(webView: wkeWebView, url: WCHAR_T)

	//150
	fun wkeLoadHTML(webView: wkeWebView, html: String)

	//151
	fun wkeLoadHtmlWithBaseUrl(webView: wkeWebView, html: String, baseUrl: String)

	//152
	fun wkeLoadFile(webView: wkeWebView, filename: String)

	//153
	fun wkeGetURL(webView: wkeWebView): String

	//154
	fun wkeNetSetHTTPHeaderField(jobPtr: Pointer, key: WCHAR_T, value: WCHAR_T, response: Boolean)

	//155
	fun wkeNetSetMIMEType(jobPtr: Pointer, type: String)

	//156
	fun wkeNetGetMIMEType(jobPtr: Pointer, mime: WkeString): String

	//157
	fun wkeNetSetData(jobPtr: Pointer, buf: Pointer, len: Int)

	//158
	fun wkeNetCancelRequest(jobPtr: Pointer)

	//159
	fun wkeNetGetFavicon(webView: wkeWebView, callback: OnNetGetFaviconCallback, param: Pointer): Int

	//160
	fun wkeNetHoldJobToAsynCommit(jobPtr: Pointer): Boolean

	//161
	fun wkeNetGetRequestMethod(jobPtr: Pointer): wkeRequestType

	//162
	fun wkeNetGetPostBody(jobPtr: Pointer): PtrwkePostBodyElements

	//163
	fun wkeNetCreatePostBodyElements(webView: wkeWebView, @size_t length: Long): PtrwkePostBodyElements

	//164
	fun wkeNetFreePostBodyElements(elements: PtrwkePostBodyElements)

	//165
	//fun wkeNetFreePostBodyElements(elements:PtrwkePostBodyElements)
	//166
	fun wkeNetCreatePostBodyElement(webView: wkeWebView): PtrwkePostBodyElements

	//167
	fun wkeNetFreePostBodyElement(element: PtrwkePostBodyElements)

	//168
	fun jsArgCount(es: JsExecState): Int

	//169
	fun jsArgType(es: JsExecState, argIdx: Int): jsType

	//170
	fun jsArg(es: JsExecState, argIdx: Int): JsValue

	//171
	fun jsTypeOf(v: JsValue): JsType

	//172
	fun jsIsNumber(v: JsValue): Boolean

	//173
	fun jsIsString(v: JsValue): Boolean

	//174
	fun jsIsBoolean(v: JsValue): Boolean

	//175
	fun jsIsObject(v: JsValue): Boolean

	//177
	fun jsIsTrue(v: JsValue): Boolean

	//178
	fun jsIsFalse(v: JsValue): Boolean

	//179
	fun jsToInt(es: JsExecState, v: JsValue): Int

	//180
	fun jsToDouble(es: JsExecState, v: JsValue): Double

	//181
	fun jsToTempStringW(es: JsExecState, v: JsValue): WCHAR_T

	//182
	fun jsToTempString(es: JsExecState, v: JsValue): String

	//183
	fun jsToString(es: JsExecState, v: JsValue): String

	//184
	fun jsToStringW(es: JsExecState, v: JsValue): WCHAR_T

	//185
	fun jsInt(n: Int): JsValue

	//186
	fun jsString(es: JsExecState, str: String): JsValue

	//187
	fun jsArrayBuffer(es: JsExecState, buffer: Pointer, @size_t size: Long): JsValue

	//188
	fun jsGetArrayBuffer(es: JsExecState, v: JsValue): MemBuf

	//189
	fun jsEmptyObject(es: JsExecState): JsValue

	//190
	fun jsEvalW(es: JsExecState, str: WCHAR_T): JsValue

	//191
	fun jsEvalExW(es: JsExecState, str: WCHAR_T, isInClosure: Boolean): JsValue

	//192
	fun jsCall(es: JsExecState, func: JsValue, thisValue: JsValue, args: jsValuePtr, argCount: Int): JsValue

	//193
	fun jsCallGlobal(es: JsExecState, func: JsValue, args: jsValuePtr, argCount: Int): JsValue

	//194
	fun jsGet(es: JsExecState, obj: JsValue, prop: String):JsValue

	//195
	fun jsSet(es: JsExecState, obj: JsValue, prop: String, v: JsValue)

	//196
	fun jsGetGlobal(es: JsExecState, prop: String): JsValue

	//197
	fun jsSetGlobal(es: JsExecState, prop: String, v: JsValue)

	//198
	fun jsGetAt(es: JsExecState, obj: JsValue, index: Int): JsValue

	//199
	fun jsSetAt(es: JsExecState, obj: JsValue, index: Int, v: JsValue)

	//200
	fun jsGetKeys(es: JsExecState, obj: JsValue): jsKeysPtr

	//201
	fun jsGetLength(es: JsExecState, obj: JsValue): Int

	//202
	fun jsSetLength(es: JsExecState, obj: JsValue, length: Int)

	//203
	fun jsGetWebView(es: JsExecState): wkeWebView

	//204
	fun jsGC()

	//205 fastcall
	@StdCall
	fun jsBindFunction(name: String, fn: JsNativeFunction, @u_int32_t argCount: Int)

	//206
	fun jsBindGetter(name: String, fn: JsNativeFunction)

	//207
	fun jsBindSetter(name: String, fn: JsNativeFunction)

	//208
	fun wkeJsBindFunction(name: String, wkefn: wkeJsNativeFunction, param: Pointer, argCount: UINT)

	//209
	fun jsObject(es: JsExecState, dat: jsDataPtr): JsValue

	//210
	fun jsFunction(es: JsExecState, dat: jsDataPtr): JsValue

	//211
	fun jsGetData(es: JsExecState, v: JsValue): JsData //jsDataPtr

	//212
	fun jsGetLastErrorIfException(es: JsExecState): JsExceptionInfo//jsExceptionInfoPtr
}


