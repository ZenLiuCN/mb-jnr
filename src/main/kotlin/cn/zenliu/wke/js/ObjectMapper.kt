package cn.zenliu.wke.js

interface ObjectMapper{
	fun<T> toJson(obj:T):String
	fun<T> fromJson(js:String):T
}
