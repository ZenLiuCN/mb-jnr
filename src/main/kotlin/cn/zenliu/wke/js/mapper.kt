package cn.zenliu.wke.js

object mapper{
	private lateinit var _mapper:ObjectMapper
	internal val mapper get()=_mapper
	@Synchronized
	fun inject(mapper: ObjectMapper){
		this._mapper=mapper
	}
}
