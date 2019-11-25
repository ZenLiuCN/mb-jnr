package cn.zenliu.wke.js

import cn.zenliu.wke.header.*
import cn.zenliu.wke.lib.*
import cn.zenliu.wke.web.*
import jnr.ffi.Runtime

class Context internal constructor(
	protected val api: WkeLib,
	protected val win: WebView,
	protected val runtime: Runtime,
	protected val env:JsExecState
){
	fun Int(int: Int) = api.jsInt(int)
	fun String(str: String) = api.jsString(env, str)
	fun Object() = api.jsEmptyObject(env)
	fun eval(str: String) = api.jsEvalW(env, str)
	fun toDouble(obj:cn.zenliu.wke.header.JsValue) = api.jsToDouble(env, obj)
	fun toInt(obj:cn.zenliu.wke.header.JsValue) = api.jsToInt(env,obj)
	fun toString2(obj:cn.zenliu.wke.header.JsValue) = api.jsToString(env, obj)
	fun toTempString(obj:cn.zenliu.wke.header.JsValue) = api.jsToTempString(env, obj)
	fun getArrayBuffer(obj:cn.zenliu.wke.header.JsValue) = api.jsGetArrayBuffer(env, obj)
	fun getProp(obj:cn.zenliu.wke.header.JsValue,prop: String)=api.jsGet(env,obj,prop)
	fun setProp(obj:cn.zenliu.wke.header.JsValue,prop: String,value:cn.zenliu.wke.header.JsValue)=api.jsSet(env,obj,prop,value)

	fun type(value:cn.zenliu.wke.header.JsValue) = api.jsTypeOf(value)
	fun isNumber(value:cn.zenliu.wke.header.JsValue) = api.jsIsNumber(value)
	fun isString(value:cn.zenliu.wke.header.JsValue) = api.jsIsString(value)
	fun isObject(value:cn.zenliu.wke.header.JsValue) = api.jsIsObject(value)
	fun isBoolean(value:cn.zenliu.wke.header.JsValue) = api.jsIsBoolean(value)
	fun isFalse(value:cn.zenliu.wke.header.JsValue) = api.jsIsFalse(value)
	fun isTrue (value:cn.zenliu.wke.header.JsValue) = api.jsIsTrue(value)


}
