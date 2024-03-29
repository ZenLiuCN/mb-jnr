package cn.zenliu.wke

/*
	//	1	 unsigned int wkeVersion();
	fun wkeVersion(): Int

	//	2	 const utf8* wkeVersionString();
	fun wkeVersionString(): String

	//	3	 void wkeSetWkeDllPath(const wchar_t* dllPath)
	fun wkeSetWkeDllPath(dllPath: String)

	//	4	 void wkeGC(wkeWebView webView, long delayMs);
	fun wkeGC(webView: HWND, delayMs: Long)

	//	5	 void wkeSetFileSystem(WKE_FILE_OPEN pfnOpen, WKE_FILE_CLOSE pfnClose, WKE_FILE_SIZE pfnSize, WKE_FILE_READ pfnRead, WKE_FILE_SEEK pfnSeek)
//	6	 bool wkeIsLoaded(wkeWebView webView); （已作废）
//	7	 bool wkeIsLoadingSucceeded(wkeWebView webView) （已作废）
//	8	 bool wkeIsLoadFailed(wkeWebView webView) （已作废）
//	9	 bool wkeIsLoadComplete(wkeWebView webView) （已作废）

	//	10	 bool wkeIsDocumentReady(wkeWebView webView)
	fun wkeIsDocumentReady(webView: HWND): Boolean

	//	11	 void wkeStopLoading(wkeWebView webView)
	fun wkeStopLoading(webView: HWND)

	//	12	 bool wkeReload(wkeWebView webView)
	fun wkeReload(webView: HWND): Boolean

	//	13	 const utf8* wkeGetTitle(wkeWebView webView)
	fun wkeGetTitle(webView: HWND): String
//	14	 const wchar_t* wkeGetTitleW(wkeWebView webView)
//	15	 void wkeResize(wkeWebView webView, int w, int h)
fun wkeResize(webView: HWND, w:Int, h:Int)

//	16	 int wkeGetWidth(wkeWebView webView)
//	17	 int wkeGetHeight(wkeWebView webView)
//	18	 int wkeGetContentWidth(wkeWebView webView)
//	19	 int wkeGetContentHeight(wkeWebView webView)
//	20	 void wkeSetDirty(wkeWebView webView, bool dirty) （已作废）
//	21	 bool wkeIsDirty(wkeWebView webView) （已作废）
//	22	 void wkeAddDirtyArea(wkeWebView webView, int x, int y, int w, int h) （已作废）
//	23	 void wkeLayoutIfNeeded(wkeWebView webView) （已作废）
//	24	 void wkePaint2(wkeWebView webView, void* bits, int bufWid, int bufHei, int xDst, int yDst, int w, int h, int xSrc, int ySrc, bool bCopyAlpha)
//	25	 void wkePaint(wkeWebView webView, void* bits, int pitch)
//	26	 void wkeRepaintIfNeeded(wkeWebView webView) （已作废）
//	27	 HDC wkeGetViewDC(wkeWebView webView)
//	28	 HWND wkeGetHostHWND(wkeWebView webView)
//	29	 bool wkeCanGoBack(wkeWebView webView)
//	30	 bool wkeGoBack(wkeWebView webView)
//	31	 bool wkeCanGoForward(wkeWebView webView)
//	32	 bool wkeGoForward(wkeWebView webView)
//	33	 void wkeEditorSelectAll(wkeWebView webView)
//	34	 void wkeEditorUnSelect(wkeWebView webView)
//	35	 void wkeEditorCopy(wkeWebView webView)
//	36	 void wkeEditorCut(wkeWebView webView)
//	37	 void wkeEditorDelete(wkeWebView webView)
//	38	 void wkeEditorUndo(wkeWebView webView)
//	39	 void wkeEditorRedo(wkeWebView webView)
//	40	 const wchar_t * wkeGetCookieW(wkeWebView webView)
//	41	 const utf8* wkeGetCookie(wkeWebView webView)
//	42	 void wkeSetCookie(wkeWebView webView, const utf8* url, const utf8* cookie)
//	43	 void wkeVisitAllCookie(void* params, wkeCookieVisitor visitor)
//	44	 void wkePerformCookieCommand(wkeWebView webView, wkeCookieCommand command)
//	45	 void wkeSetCookieEnabled(wkeWebView webView, bool enable)
//	46	 bool wkeIsCookieEnabled(wkeWebView webView)
//	47	 void wkeSetCookieJarPath(wkeWebView webView, const WCHAR* path)
//	48	 void wkeSetCookieJarFullPath(wkeWebView webView, const WCHAR* path)
//	49	 void wkeSetLocalStorageFullPath(wkeWebView webView, const WCHAR* path)
//	50	 void wkeSetMediaVolume(wkeWebView webView, float volume)
//	51	 float wkeGetMediaVolume(wkeWebView webView)
//	52	 bool wkeFireMouseEvent(wkeWebView webView, unsigned int message, int x, int y, unsigned int flags)
//	53	 bool wkeFireContextMenuEvent(wkeWebView webView, int x, int y, unsigned int flags)
//	54	 bool wkeFireMouseWheelEvent(wkeWebView webView, int x, int y, int delta, unsigned int flags)
//	55	 bool wkeFireKeyUpEvent(wkeWebView webView, unsigned int virtualKeyCode, unsigned int flags, bool systemKey)
//	56	 bool wkeFireKeyDownEvent(wkeWebView webView, unsigned int virtualKeyCode, unsigned int flags, bool systemKey)
//	57	 bool wkeFireWindowsMessage(wkeWebView webView, HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam, LRESULT* result)
//	58	 void wkeSetFocus(wkeWebView webView)
//	59	 void wkeKillFocus(wkeWebView webView)
//	60	 wkeRect wkeGetCaretRect(wkeWebView webView)
//	61	 jsValue wkeRunJS(wkeWebView webView, const utf8* script)
//	62	 jsValue wkeRunJSW(wkeWebView webView, const wchar_t* script)
//	63	 jsExecState wkeGlobalExec(wkeWebView webView)
//	64	 void wkeSleep(wkeWebView webView)
//	65	 void wkeWake(wkeWebView webView)
//	66	 bool wkeIsAwake(wkeWebView webView)
//	67	 void wkeSetZoomFactor(wkeWebView webView, float factor)
//	68	 float wkeGetZoomFactor(wkeWebView webView)
//	69	 void wkeSetEditable(wkeWebView webView, bool editable)
//	70	 void wkeOnTitleChanged(wkeWebView webView, wkeTitleChangedCallback callback, void* callbackParam)
//	71	 void wkeOnMouseOverUrlChanged(wkeWebView webView, wkeTitleChangedCallback callback, void* callbackParam)
//	72	 void wkeOnURLChanged(wkeWebView webView, wkeURLChangedCallback callback, void* callbackParam)
//	73	 void wkeOnURLChanged2(wkeWebView webView, wkeURLChangedCallback2 callback, void* callbackParam)
//	75	 void wkeOnPaintUpdated(wkeWebView webView, wkePaintUpdatedCallback callback, void* callbackParam)
//	77	 void wkeOnPaintBitUpdated(wkeWebView webView, wkePaintBitUpdatedCallback callback, void* callbackParam)
//	78	 void wkeOnAlertBox(wkeWebView webView, wkeAlertBoxCallback callback, void* callbackParam)
//	79	 void wkeOnConfirmBox(wkeWebView webView, wkeConfirmBoxCallback callback, void* callbackParam)
//	80	 void wkeOnPromptBox(wkeWebView webView, wkePromptBoxCallback callback, void* callbackParam)
//	81	 void wkeOnNavigation(wkeWebView webView, wkeNavigationCallback callback, void* param)
//	83	 void wkeOnCreateView(wkeWebView webView, wkeCreateViewCallback callback, void* param)
//	85	 void wkeOnDocumentReady(wkeWebView webView, wkeDocumentReadyCallback callback, void* param)
//	86	 void wkeOnDocumentReady2(wkeWebView webView, wkeDocumentReady2Callback callback, void* param)
//	87	 void wkeOnDownload(wkeWebView webView, wkeDownloadCallback callback, void* param)
//	88	 void wkeNetOnResponse(wkeWebView webView, wkeNetResponseCallback callback, void* param)
//	89	 void wkeOnConsole(wkeWebView webView, wkeConsoleCallback callback, void* param)
//	90	 void wkeSetUIThreadCallback(wkeWebView webView, wkeCallUiThread callback, void* param)
//	91	 void wkeOnLoadUrlBegin(wkeWebView webView, wkeLoadUrlBeginCallback callback, void* callbackParam)
//	92	 void wkeOnLoadUrlEnd(wkeWebView webView, wkeLoadUrlEndCallback callback, void* callbackParam)
//	93	 void wkeOnDidCreateScriptContext(wkeWebView webView, wkeDidCreateScriptContextCallback callback, void* callbackParam)
//	94	 void wkeOnWillReleaseScriptContext(wkeWebView webView, wkeWillReleaseScriptContextCallback callback, void* callbackParam)
//	95	 void wkeOnWillMediaLoad(wkeWebView webView, wkeWillMediaLoadCallback callback, void* callbackParam)
//	96	 bool wkeIsMainFrame(wkeWebView webView, wkeWebFrameHandle frameId)
//	97	 wkeWebFrameHandle wkeWebFrameGetMainFrame(wkeWebView webView)
//	98	 jsValue wkeRunJsByFrame(wkeWebView webView, wkeWebFrameHandle frameId, const utf8* script, bool isInClosure)
//	99	 const utf8* wkeGetFrameUrl(wkeWebView webView, wkeWebFrameHandle frameId)
//	100	 const utf8* wkeGetString(const wkeString s)
//	101	 const wchar_t* wkeGetStringW(const wkeString string)const wchar_t* wkeGetStringW(const wkeString string)
//	102	 void wkeSetString(wkeString string, const utf8* str, size_t len)
//	103	 void wkeSetStringW(wkeString string, const wchar_t* str, size_t len)
//	104	 wkeString wkeCreateStringW(const wchar_t* str, size_t len)
//	105	 void wkeDeleteString(wkeString str)
//	106	 void wkeSetUserKeyValue(wkeWebView webView, const char* key, void* value)
//	107	 void* wkeGetUserKeyValue(wkeWebView webView, const char* key)
//	108	 int wkeGetCursorInfoType(wkeWebView webView)
//	109	 wkeWebView wkeCreateWebView()
//	110	 void wkeDestroyWebView(wkeWebView webView)
//	111	 wkeWebView wkeCreateWebWindow(wkeWindowType type, HWND parent, int x, int y, int width, int height)
//	112	 void wkeDestroyWebWindow(wkeWebView webWindow)
//	113	 HWND wkeGetWindowHandle(wkeWebView webWindow)
//	114	 void wkeOnWindowClosing(wkeWebView webWindow, wkeWindowClosingCallback callback, void* param)
//	115	 void wkeOnWindowDestroy(wkeWebView webWindow, wkeWindowDestroyCallback callback, void* param)
//	116	 void wkeShowWindow(wkeWebView webWindow, bool showFlag)
//	117	 void wkeEnableWindow(wkeWebView webWindow, bool enableFlag)
//	118	 void wkeMoveWindow(wkeWebView webWindow, int x, int y, int width, int height)
//	119	 void wkeMoveToCenter(wkeWebView webWindow)
//	120	 void wkeResizeWindow(wkeWebView webWindow, int width, int height)
//	121	 void wkeSetWindowTitle(wkeWebView webWindow, const utf8* title)
//	122	 void wkeSetWindowTitle(wkeWebView webWindow, const wchar_t* title)
//	123	 void wkeSetDeviceParameter(wkeWebView webView, const char* device, const char* paramStr, int paramInt, float paramFloat)
//	124	 void wkeInit()
//	125	 void wkeShutdown() （已作废）
//	126	 void wkeInitialize()
//	127	 void wkeSetProxy(const wkeProxy* proxy)
//	128	 void wkeSetViewProxy(wkeWebView webView, wkeProxy* proxy)
//	129	 void wkeConfigure(const wkeSettings* settings)
//	130	 bool wkeIsInitialize()
//	131	 void wkeFinalize() （已作废）
//	132	 void wkeSetMemoryCacheEnable(wkeWebView webView, bool b)
//	133	 void wkeSetTouchEnabled(wkeWebView webView, bool b)
//	134	 void wkeSetMouseEnabled(wkeWebView webView, bool b)
//	135	 void wkeSetNavigationToNewWindowEnable(wkeWebView webView, bool b)
//	136	 void wkeSetCspCheckEnable(wkeWebView webView, bool b)
//	137	 void wkeSetNpapiPluginsEnabled(wkeWebView webView, bool b)
//	138	 void wkeSetHeadlessEnabled(wkeWebView webView, bool b)
//	139	 void wkeSetDebugConfig(wkeWebView webView, const char* debugString, const char* param)
//	140	 void wkeSetHandle(wkeWebView webView, HWND wnd)
//	141	 void wkeSetHandleOffset(wkeWebView webView, int x, int y)
//	142	 void wkeSetViewSettings(wkeWebView webView, const wkeViewSettings* settings)
//	143	 void wkeSetTransparent(wkeWebView webView, bool transparent)
//	144	 bool wkeIsTransparent(wkeWebView webView)
//	145	 void wkeSetUserAgent(wkeWebView webView, const utf8* userAgent)
//	146	 void wkeSetUserAgentW(wkeWebView webView, const wchar_t* userAgent)
//	147	 const utf8* wkeGetUserAgent(wkeWebView webView)
//	148	 void wkeLoadURL(wkeWebView webView, const utf8* url)
//	149	 void wkeLoadW(wkeWebView webView, const wchar_t* url)
//	150	 void wkeLoadHTML(wkeWebView webView, const utf8* html)
//	151	 void wkeLoadHtmlWithBaseUrl(wkeWebView webView, const utf8* html, const utf8* baseUrl)
//	152	 void wkeLoadFile(wkeWebView webView, const utf8* filename)
//	153	 const utf8* wkeGetURL(wkeWebView webView)
//	154	 void wkeNetSetHTTPHeaderField(void* jobPtr, wchar_t* key, wchar_t* value, bool response)
//	155	 void wkeNetSetMIMEType(void* jobPtr, char* type)
//	156	 const char* wkeNetGetMIMEType(void* jobPtr, wkeString mime)
//	157	 void wkeNetSetData(void* jobPtr, void* buf, int len)
//	158	 void wkeNetCancelRequest(void* jobPtr)
//	159	 int wkeNetGetFavicon(wkeWebView webView, wkeOnNetGetFavicon callback, void* param)
//	160	 BOOL wkeNetHoldJobToAsynCommit(void* jobPtr)
//	161	 wkeRequestType wkeNetGetRequestMethod(void *jobPtr)
//	162	 wkePostBodyElements* wkeNetGetPostBody(void *jobPtr)
//	163	 wkePostBodyElements* wkeNetCreatePostBodyElements(wkeWebView webView, size_t length)
//	164	 void wkeNetFreePostBodyElements(wkePostBodyElements* elements)
//	165	 void wkeNetFreePostBodyElements(wkePostBodyElements* elements)
//	166	 wkePostBodyElement* wkeNetCreatePostBodyElement(wkeWebView webView)
//	167	 void wkeNetFreePostBodyElement(wkePostBodyElement* element)
//	168	 int jsArgCount(jsExecState es)
//	169	 jsType jsArgType(jsExecState es, int argIdx)
//	170	 jsValue jsArg(jsExecState es, int argIdx)
//	171	 jsType jsTypeOf(jsValue v)
//	172	 bool jsIsNumber(jsValue v)
//	173	 bool jsIsString(jsValue v)
//	174	 bool jsIsBoolean(jsValue v)
//	175	 bool jsIsObject(jsValue v)
//	176	 当v不是数字、字符串、undefined、null、函数的时候，此接口返回true
//	177	 bool jsIsTrue(jsValue v)
//	178	 bool jsIsFalse(jsValue v)
//	179	 int jsToInt(jsExecState es, jsValue v)
//	180	 double jsToDouble(jsExecState es, jsValue v)
//	181	 const wchar_t* jsToTempStringW(jsExecState es, jsValue v)
//	182	 const utf8* jsToTempString(jsExecState es, jsValue v)
//	183	 const utf8* jsToString(jsExecState es, jsValue v)
//	184	 const wchar_t* jsToStringW(jsExecState es, jsValue v)
//	185	 jsValue jsInt(int n)
//	186	 jsValue jsString(jsExecState es, const utf8* str)
//	187	 jsValue jsArrayBuffer(jsExecState es, char * buffer, size_t size)
//	188	 wkeMemBuf* jsGetArrayBuffer(jsExecState es, jsValue value)
//	189	 jsValue jsEmptyObject(jsExecState es)
//	190	 jsValue jsEvalW(jsExecState es, const wchar_t* str)
//	191	 jsValue jsEvalExW(jsExecState es, const wchar_t* str, bool isInClosure)
//	192	 jsValue jsCall(jsExecState es, jsValue func, jsValue thisValue, jsValue* args, int argCount)
//	193	 jsValue jsCallGlobal(jsExecState es, jsValue func, jsValue* args, int argCount)
//	194	 jsValue jsGet(jsExecState es, jsValue object, const char* prop)
//	195	 void jsSet(jsExecState es, jsValue object, const char* prop, jsValue value)
//	196	 jsValue jsGetGlobal(jsExecState es, const char* prop)
//	197	 void jsSetGlobal(jsExecState es, const char* prop, jsValue v)
//	198	 jsValue jsGetAt(jsExecState es, jsValue object, int index)
//	199	 void jsSetAt(jsExecState es, jsValue object, int index, jsValue value)
//	200	 jsKeys* jsGetKeys(jsExecState es, jsValue object)
//	201	 int jsGetLength(jsExecState es, jsValue object)
//	202	 void jsSetLength(jsExecState es, jsValue object, int length)
//	203	 wkeWebView jsGetWebView(jsExecState es)
//	204	 void jsGC()
//	205	 void fastcall jsBindFunction(const char* name, jsNativeFunction fn, unsigned int argCount)
//	206	 void jsBindGetter(const char* name, jsNativeFunction fn)
//	207	 void jsBindSetter(const char* name, jsNativeFunction fn)
//	208	 void wkeJsBindFunction(const char* name, wkeJsNativeFunction fn, void* param, unsigned int argCount)
//	209	 jsValue jsObject(jsExecState es, jsData* data)
//	210	 jsValue jsFunction(jsExecState es, jsData* data)
//	211	 jsData* jsGetData(jsExecState es, jsValue value)
//	212	 jsExceptionInfo* jsGetLastErrorIfException(jsExecState es);
 */
