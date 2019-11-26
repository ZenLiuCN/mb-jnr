package cn.zenliu.wke

import cn.zenliu.wke.header.*
import cn.zenliu.wke.lib.*
import javafx.application.*
import javafx.stage.*
import java.time.*

class App : Application() {
	override fun start(primaryStage: Stage) {

		primaryStage.show()

		val hwnd = primaryStage.impl_getPeer()
			.rawHandle
			.let {
				WKE.init()
				WKE.newPointer(it)
			}
		val win = WKE.createWebWindow(0, 0, primaryStage.width.toInt(), primaryStage.height.toInt(), WindowType.WINDOW_TYPE_CONTROL, hwnd)
		win.showWindow(true)
		win.onConsole { view, level, message, sourceLine, stackTrace ->
			println("${Instant.now()} ${view.title}[$level]:\n $message <$sourceLine>\n$stackTrace")
		}
		win.load("http://www.baidu.com")
		win.onDocumentReady2 {vw,id->
			println("----doument Ready $id----")
			println(vw.document.query("#s_mp > area"))


		}


	}

}

fun main(args: Array<String>) {
	Application.launch(App::class.java, *args)
}
