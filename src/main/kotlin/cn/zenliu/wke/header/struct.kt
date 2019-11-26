package cn.zenliu.wke.header

import jnr.ffi.*
import jnr.ffi.annotations.*
import java.nio.charset.*


class Rect(
	runtime: Runtime
) : Struct(runtime) {
	val x: Int = 0
	val y: Int = 0
	val w: Int = 0
	val h: Int = 0
}

class Point(
	runtime: Runtime
) : Struct(runtime) {
	val x: Int = 0
	val y: Int = 0
}

class Proxy(
	runtime: Runtime
) : Struct(runtime) {
	val hostName: String = UTFString(0, Charset.defaultCharset())
	val port: Int = 0
	val username: String = UTFString(0, Charset.defaultCharset())
	val password: String = UTFString(0, Charset.defaultCharset())
}

class Settings(
	runtime: Runtime
) : Struct(runtime) {
	val proxy = StructRef(Proxy::class.java)
	val mask: Int = 0
}

class ViewSettings(
	runtime: Runtime
) : Struct(runtime) {
	val size: Int = 0
	val bgColor: Int = 0
}

class GeolocationPosition(
	runtime: Runtime
) : Struct(runtime) {
	val timestamp: Double = Double()
	val latitude: Double = Double()
	val longitude: Double = Double()
	val accuracy: Double = Double()
	val providesAltitude: Boolean = Boolean()
	val altitude: Double = Double()
	val providesAltitudeAccuracy: Boolean = Boolean()
	val altitudeAccuracy: Double = Double()
	val providesHeading: Boolean = Boolean()
	val heading: Double = Double()
	val providesSpeed: Boolean = Boolean()
	val speed: Double = Double()
}

class ClientHandler(
	runtime: Runtime
) : Struct(runtime) {
	val onTitleChanged = Function(ON_TITLE_CHANGED::class.java)
	val onURLChanged = Function(ON_URL_CHANGED::class.java)
}


class WindowFeatures(

	runtime: Runtime
) : Struct(runtime) {
	val x = Signed32()
	val y = Signed32()
	val width = Signed32()
	val height = Signed32()

	val menuBarVisible = Boolean()
	val statusBarVisible = Boolean()
	val toolBarVisible = Boolean()
	val locationBarVisible = Boolean()
	val scrollbarsVisible = Boolean()
	val resizable = Boolean()
	val fullscreen = Boolean()
}

class MemBuf(
	runtime: Runtime
) : Struct(runtime){
	val size=Unsigned32()
	val dat=Address()
	val length=size_t()
}

class Item(
	runtime: Runtime
) : Struct(runtime){
	val stringType=StructRef(MemBuf::class.java)
	val stringData=StructRef(MemBuf::class.java)
	val filenameData=StructRef(MemBuf::class.java)
	val displayNameData=StructRef(MemBuf::class.java)
	val binaryData=StructRef(MemBuf::class.java)
	val title=StructRef(MemBuf::class.java)
	val fileSystemURL=StructRef(MemBuf::class.java)
	val fileSystemFileSize=size_t()
	val baseURL=StructRef(MemBuf::class.java)
}

class DragData(
	runtime: Runtime
) : Struct(runtime){
	val itemList=StructRef(Item::class.java)
	val itemListLength=Unsigned32()
	val modifireKeyState=Unsigned32()
	val fileSystemId=StructRef(MemBuf::class.java)
}


class WillSendRequestInfo(
	runtime: Runtime
) : Struct(runtime){
	val url=Address() //WkeString
	val newUrl=Address()
	val resourceType=Enum(ResourceType::class.java)
	val httpResponseCode=Unsigned32()
	val method=Address()
	val referrer=Address()
	val headers=Address()
}


class PostBodyElement(

	runtime: Runtime
) : Struct(runtime){
	val size=Unsigned32()
	val type=Enum( HttBodyElementType::class.java)//HttBodyElementType
	val dat=StructRef(MemBuf::class.java)
	val filePath=Address()
	val fileStart=Signed64()
	val fileLength=Signed64() // -1 means to the end of the file.
}

class PostBodyElements(
	runtime: Runtime
) : Struct(runtime){
	val size=Unsigned32()
	val element=StructRef(PostBodyElement::class.java)
	val elementSize=size_t()
	val isDirty=Boolean()
}

class Slist(
	runtime: Runtime
) : Struct(runtime){
	val data=Address()
	val next=StructRef(Slist::class.java)
}

class TempCallbackInfo(
	runtime: Runtime
) : Struct(runtime){
	val size=Unsigned32()
	val willSendRequestInfo=Function(WillSendRequestInfo::class.java)
	val url=UTF8StringRef()
	val postBody=StructRef(PostBodyElements::class.java)
	val job=Address()
}

class PrintSettings(

	runtime: Runtime
) : Struct(runtime){
	val structSize=Unsigned32()
	val dpi=Unsigned32()
	val width=Unsigned32() // in px
	val height=Unsigned32()
	val marginTop=Unsigned32()
	val marginBottom=Unsigned32()
	val marginLeft=Unsigned32()
	val marginRight=Unsigned32()
	val isPrintPageHeadAndFooter=Boolean()
	val isPrintBackgroud=Boolean()
	val isLandscape=Boolean()
}

class ScreenshotSettings(

	runtime: Runtime
) : Struct(runtime){
	val structSize=Unsigned32()
	val width=Unsigned32()
	val height=Unsigned32()
}

class MediaLoadInfo(

	runtime: Runtime
) : Struct(runtime){
	val size=Unsigned32()
	val width=Unsigned32()
	val height=Unsigned32()
	val duration=Double()
}

class NetJobDataBind(

	runtime: Runtime
) : Struct(runtime){
	val param=Address()
	val recvCallback=Function(NetJobDataRecvCallback::class.java)
	val finishCallback=Function(NetJobDataFinishCallback::class.java)
}

class WindowCreateInfo(
	runtime: Runtime
) : Struct(runtime){
	val size=Unsigned32()
	val parent=Address()
	val style=DWORD()
	val styleEx=DWORD()
	val x=Unsigned32()
	val y=Unsigned32()
	val width=Unsigned32()
	val height=Unsigned32()
	val color=Address()
}

class DraggableRegion(
	runtime: Runtime
) : Struct(runtime){
	val bounds=StructRef(Rect::class.java)
	val draggable= Boolean()
}

class JsData(
	runtime: Runtime
) : Struct(runtime){
	val typeName=UTFStringRef(Charset.defaultCharset())
	val propertyGet=Function( JsGetPropertyCallback::class.java)
	val propertySet=Function( JsSetPropertyCallback::class.java)
	val finalize=Function( JsFinalizeCallback::class.java)
	val callAsFunction=Function(JsCallAsFunctionCallback::class.java)
}

class JsExceptionInfo(

	runtime: Runtime
) : Struct(runtime){
	val message=UTFStringRef(Charset.defaultCharset()) // Returns the exception message.
	val sourceLine=UTFStringRef(Charset.defaultCharset()) // Returns the line of source code that the exception occurred within.
	val scriptResourceName=UTFStringRef(Charset.defaultCharset()) // Returns the resource name for the script from where the function causing the error originates.
	val lineNumber=Unsigned32() // Returns the 1-based number of the line where the error occurred or 0 if the line number is unknown.
	val startPosition=Unsigned32() // Returns the index within the script of the first character where the error occurred.
	val endPosition=Unsigned32() // Returns the index within the script of the last character where the error occurred.
	val startColumn=Unsigned32() // Returns the index within the line of the first character where the error occurred.
	val endColumn=Unsigned32() // Returns the index within the line of the last character where the error occurred.
	val callstackString=UTFStringRef(Charset.defaultCharset())
}

class JsKeys(

	runtime: Runtime
) : Struct(runtime){
	val length=Unsigned32()
	val keys=Address()
}

class UrlRequestCallbacks(
	runtime: Runtime
) : Struct(runtime){
	val willRedirectCallback=Function(OnUrlRequestWillRedirectCallback::class.java)
	val didReceiveResponseCallback=Function(OnUrlRequestDidReceiveResponseCallback::class.java)
	val didReceiveDataCallback=Function(OnUrlRequestDidReceiveDataCallback::class.java)
	val didFailCallback=Function(OnUrlRequestDidFailCallback::class.java)
	val didFinishLoadingCallback=Function(OnUrlRequestDidFinishLoadingCallback::class.java)
}
/*class WkeString(
	runtime: Runtime
):Struct(runtime){

}*/
