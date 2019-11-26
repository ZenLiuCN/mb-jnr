package cn.zenliu.wke.js

import cn.zenliu.wke.header.*

open class JsElement internal constructor(
	protected val value: JsValue,
	protected val ctx: Context
) {
	internal val type get() = ctx.type(value)
	internal val isNumber get() = ctx.isNumber(value)
	internal val isString get() = ctx.isString(value)
	internal val isObject get() = ctx.isObject(value)
	internal val isBoolean get() = ctx.isBoolean(value)
	internal val isFalse get() = ctx.isFalse(value)
	internal val isTrue get() = ctx.isTrue(value)
	internal val isNull get() = ctx.isNull(value)
	internal val isFunction get() = ctx.isFunction(value)
	internal val isUndefined get() = ctx.isUndefined(value)
	internal val isArray get() = ctx.isArray(value)
	internal val length = takeIf { isArray }?.let { ctx.getLength(value) }

	internal operator fun set(prop: String, v: Any) = when {
		!isObject -> throw Throwable("not js object")
		v is Int -> ctx.Int(v).let { ctx.setProp(value, prop, it) }
		v is String -> ctx.String(v).let { ctx.setProp(value, prop, it) }
		v is Boolean -> ctx.Bool(v).let { ctx.setProp(value, prop, it) }
		v is Float -> ctx.Float(v).let { ctx.setProp(value, prop, it) }
		v is Double -> ctx.Double(v).let { ctx.setProp(value, prop, it) }
		v is JsElement -> ctx.setProp(value, prop, v.value)
		else -> Unit
	}

	internal operator fun get(prop: String) = if (!isObject) {
		throw Throwable("not js object")
	} else JsElement(ctx.getProp(value, prop), ctx)

	internal operator fun set(idx: Int, v: Any) = when {
		!isObject -> throw Throwable("not js object")
		v is Int -> ctx.Int(v).let { ctx.setAt(value, idx, it) }
		v is String -> ctx.String(v).let { ctx.setAt(value, idx, it) }
		v is Boolean -> ctx.Bool(v).let { ctx.setAt(value, idx, it) }
		v is Float -> ctx.Float(v).let { ctx.setAt(value, idx, it) }
		v is Double -> ctx.Double(v).let { ctx.setAt(value, idx, it) }
		v is JsElement -> ctx.setAt(value, idx, v.value)
		else -> Unit
	}

	internal operator fun get(idx: Int) = if (!isArray) {
		throw Throwable("not js Array")
	} else JsElement(ctx.getAt(value, idx), ctx)

	internal fun toDouble() = ctx.toDouble(value)
	override fun toString(): String = ctx.toString2(value)
	internal fun toInt() = takeIf { it.isNumber }?.let { ctx.toInt(value) }
	internal fun toBoolean() = ctx.toBoolean(value)
	internal fun toFloat() = ctx.toFloat(value)
	internal fun asBoolean() = this.isTrue

	internal fun eval(script: String) = ctx.evalReturn(script)
	fun asJsBoolean() = JsBool(this)
	fun asJsFloat() = JsFloat(this)
	fun asJsString() = JsString(this)
	fun asJsInt() = JsInt(this)
	fun asJsDouble() = JsDouble(this)
	fun asJsObject() = JsObject(this)
}

class JsBool internal constructor(private val element: JsElement) {
	val value
		get() = element.isTrue
}

class JsFloat internal constructor(private val element: JsElement) {
	val value
		get() = element.toFloat()
}

class JsDouble internal constructor(private val element: JsElement) {
	val value
		get() = element.toDouble()
}

class JsString internal constructor(private val element: JsElement) {
	val value
		get() = element.toString()
}

class JsInt internal constructor(private val element: JsElement) {
	val value
		get() = element.toInt()
}

//todo
open class JsObject internal constructor(protected val element: JsElement) {
	val value
		get() = element

	fun asJsDocument() = JsDocument(element)
}

open class JsDocument internal constructor(element: JsElement) : JsObject(element) {
	fun query(path: String) = element.eval("document.querySelector('$path')").let { JsHtmlElement(it) }
	fun queryAll(path: String) = element.eval("document.querySelectorAll('$path')").let { JsHtmlElements(it) }
}

class JsHtmlElement internal constructor(element: JsElement) : JsDocument(element) {

}

class JsHtmlElements internal constructor(element: JsElement) : JsDocument(element) {
	val length = element.length
	operator fun get(idx: Int) = length.takeIf { length != null && idx < length }?.let { JsHtmlElement(element[idx]) }
	fun forEach(call:(JsHtmlElement)->Unit){
		length?.let { len->
			(0 until len ).forEach {
				call.invoke(this[it]!!)
			}
		}
	}
}
