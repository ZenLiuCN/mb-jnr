package cn.zenliu.wke.js

import cn.zenliu.wke.header.*
import cn.zenliu.wke.lib.*
import cn.zenliu.wke.web.*
import jnr.ffi.*
import java.nio.*

class Context internal constructor(
	protected val api: WkeLib,
	protected val win: WebView,
	protected val runtime: Runtime,
	protected val env: JsExecState
) {
	val isContextValid get() = api.jsIsValidExecState(env)
	fun isValueValid(v: JsValue) = api.jsIsJsValueValid(env, v)
	fun Int(v: Int) = api.jsInt(v)
	fun Bool(v: Boolean) = api.jsBoolean(v)
	fun Double(v: Double) = api.jsDouble(v)
	fun Float(v: Float) = api.jsFloat(v)

	fun String(str: String) = api.jsString(env, str)
	fun Object() = api.jsEmptyObject(env)
	fun Array() = api.jsEmptyArray(env)
	fun GlobalObject() = api.jsGlobalOBject(env)
	fun Null() = api.jsNull()
	fun True() = api.jsTrue()
	fun False() = api.jsFalse()
	fun Undefined() = api.jsUndefined()

	fun getWebView() = api.jsGetWebView(env).let { WebView(api, it, runtime) }
	fun evalReturn(str: String) = api.jsEval(env, "return ($str)").let{JsElement(it,this)}
	fun eval(str: String) = api.jsEval(env, str).let{JsElement(it,this)}

	fun toDouble(obj: JsValue) = api.jsToDouble(env, obj)
	fun toFloat(obj: JsValue) = api.jsToFloat(env, obj)
	fun toBoolean(obj: JsValue) = api.jsToBoolean(env, obj)
	fun toInt(obj: JsValue) = api.jsToInt(env, obj)
	fun toString2(obj: JsValue) = api.jsToString(env, obj)
	fun toTempString(obj: JsValue) = api.jsToTempString(env, obj)

	fun arrayBuffer(buf: ByteBuffer, size: Long) = api.jsArrayBuffer(env, buf, size)
	fun getArrayBuffer(obj: JsValue) = api.jsGetArrayBuffer(env, obj)

	fun getAt(obj: JsValue, idx: Int) = api.jsGetAt(env, obj, idx)
	fun setAt(obj: JsValue, idx: Int, value: JsValue) = api.jsSetAt(env, obj, idx, value)
	fun getLength(obj: JsValue) = api.jsGetLength(env, obj)
	fun setLength(obj: JsValue, length: Int) = api.jsSetLength(env, obj, length)

	fun getKeys(obj: JsValue) = api.jsGetKeys(env, obj)
	fun getProp(obj: JsValue, prop: String) = api.jsGet(env, obj, prop)
	fun setProp(obj: JsValue, prop: String, value: JsValue) = api.jsSet(env, obj, prop, value)
	fun delProp(obj: JsValue, prop: String) = api.jsDeleteObjectProp(env, obj, prop)

	fun type(value: JsValue) = api.jsTypeOf(value)

	fun isNumber(value: JsValue) = api.jsIsNumber(value)
	fun isString(value: JsValue) = api.jsIsString(value)
	fun isObject(value: JsValue) = api.jsIsObject(value)
	fun isBoolean(value: JsValue) = api.jsIsBoolean(value)
	fun isFalse(value: JsValue) = api.jsIsFalse(value)
	fun isTrue(value: JsValue) = api.jsIsTrue(value)
	fun isNull(value: JsValue) = api.jsIsNull(value)
	fun isFunction(value: JsValue) = api.jsIsFunction(value)
	fun isUndefined(value: JsValue) = api.jsIsUndefined(value)
	fun isArray(value: JsValue) = api.jsIsArray(value)

	fun getGlobal(prop: String) = api.jsGetGlobal(env, prop)
	fun setGlobal(prop: String, value: JsValue) = api.jsSetGlobal(env, prop, value)

	fun call(jsFn: JsValue, self: JsValue, vararg args: JsValue) = api.jsCall(env, jsFn, self,
		Pointer.newIntPointer(runtime, 0)//!! todo
		, args.size)

	fun callGlobal(jsFn: JsValue, vararg args: JsValue) = api.jsCallGlobal(env, jsFn,
		Pointer.newIntPointer(runtime, 0)//!! todo
		, args.size)
	fun gc()=api.jsGC()
	fun addRef(value: JsValue)=api.jsAddRef(env,value)
	fun releaseRef(value: JsValue)=api.jsReleaseRef(env,value)
	fun getLastErrorIfException()=api.jsGetLastErrorIfException(env)
	fun throwException(exception:String)=api.jsThrowException(env,exception)
	fun getCallstack()=api.jsGetCallstack(env)

}
