package cn.zenliu.wke.lib

import cn.zenliu.wke.header.*
import cn.zenliu.wke.web.*
import jnr.ffi.*
import java.lang.ref.*



class WKE private constructor() {
	private val api = LibraryLoader.create(WkeLib::class.java).load("miniblink_x64")
	private val runtime = Runtime.getRuntime(api)

	init {
		api.wkeInit()
	}


	private fun createWebWindow(
		x: Int, y: Int, w: Int, h: Int, type: WindowType, parent: Pointer? = null) = api.wkeCreateWebWindow(
		type, parent, x, y, w, h).let { WebWindow(api,it,runtime) }
	private fun newPointer(address: Long)=Pointer.newIntPointer(runtime,address)
	private fun fetchWkeString(str:WkeString)=str.getString(0)


	companion object {
		private lateinit var lib: WKE
		fun init() {
			if (this::lib.isInitialized) return
			lib = WKE()
		}

		fun createWebWindow(
			x: Int, y: Int, w: Int, h: Int, type: WindowType = WindowType.WINDOW_TYPE_POPUP, parent: Pointer? = null) = lib
			.createWebWindow(x, y, w, h, type, parent)
		internal val api get() = lib.api
		fun newPointer(address: Long)=lib.newPointer(address)
		fun fetchWkeString(str: WkeString)=str.getString(0)
	}
}
