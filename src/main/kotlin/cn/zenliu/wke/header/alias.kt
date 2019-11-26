package cn.zenliu.wke.header

import jnr.ffi.*
import jnr.ffi.byref.*

typealias WebFrameHandle = Int
typealias MemBufPtr =Pointer// Struct.StructRef<MemBuf>
typealias VoidPtr = Pointer?
typealias STARTUPINFOW = VoidPtr


typealias WebDragOperationsMask = Long
typealias WkeString = Pointer
typealias NetJob = Pointer

typealias HDC = Pointer
typealias HWND = Pointer
/*typealias jsExecState = JsExecStateInfo?
typealias JsExecStateInfo = VoidPtr*/

typealias WebUrlRequestPtr = VoidPtr
typealias WebUrlResponsePtr = VoidPtr
typealias MediaPlayerClient = VoidPtr
typealias MediaPlayer = VoidPtr
typealias COLORREF = VoidPtr
typealias JsExecState = VoidPtr
//int64
typealias JsValue=Pointer

