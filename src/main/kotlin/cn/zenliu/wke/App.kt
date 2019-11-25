package cn.zenliu.wke

import cn.zenliu.wke.lib.*


fun main() {
	WKE.init()
	val win= WKE.createWebWindow(0,0,800,480)
	win.onUrlChange2{vw,url->
		println("url changed $url")
	}
	println(win.title)
	win.load("http://www.baidu.com")
	println(win.url)
	Thread.sleep(5000)
	println(win.title)
}
