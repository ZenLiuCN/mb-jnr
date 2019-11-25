package cn.zenliu.wke.js

import cn.zenliu.wke.header.*

open class JsElement internal constructor(
	protected val value:JsValue,
	protected val ctx:Context
){
	internal val type get() = ctx.type(value)
	internal val isNumber get() = ctx.isNumber(value)
	internal val isString get() = ctx.isString(value)
	internal val isObject get() = ctx.isObject(value)
	internal val isBoolean get() = ctx.isBoolean(value)
	internal val isFalse get() = ctx.isFalse(value)
	internal val isTrue get() = ctx.isTrue(value)
	internal operator fun set(prop:String,v:Any)=when{
		!isObject->throw Throwable("not js object")
		v is Int->ctx.Int(v).let { ctx.setProp(value,prop,it) }
		v is String->ctx.String(v).let { ctx.setProp(value,prop,it) }
		v is String->ctx.String(v).let { ctx.setProp(value,prop,it) }
		else->Unit
	}
	internal operator fun get(prop: String)=if(!isObject){
		throw Throwable("not js object")
	}else JsElement(ctx.getProp(value,prop),ctx)

	internal fun toDouble()=isNumber.takeIf { it }?.let { ctx.toDouble(value) }?:throw Throwable("not js number")
	internal fun toString2()=ctx.toString2(value)
	internal fun toInt()=ctx.toInt(value)
}
class JsBool internal constructor(private val element: JsElement){
	val value
		get() = element.isTrue
}
class JsString internal constructor(private val element: JsElement){
	val value
		get() = element.toString2()
}
class JsInt internal constructor(private val element: JsElement){
	val value
		get() = element.toString2()
}
//todo
class JsObject internal constructor(private val element: JsElement){
	val value
		get() = element.toString2()
}
