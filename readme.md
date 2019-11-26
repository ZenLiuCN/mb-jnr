# ABOUT
 this repo try to integration miniblink with ktolin by  jnr-ffi,
 so I will write some notes for how to use jnr-ffi just here;
 # LICENCE
 all source code is  licensed under `the Apache License, Version 2.0`,
 except wke.h (which is as it's writter's licence);
 
 content of this markdown file is  licensed under  `Creative Commons License`;
 
 # notes
+ how to define callback function in jnr-ffi?
```kotlin
 interface SomeCallbackIface{
    @Delegate
    fun func(someParam:Pointer) //can be simple value (can be nullable)
 }
 interface WkeLib{
    fun functionWithCallback(someObject:Pointer,someCallback:SomeCallbackIface)
 }
```
+ how to map struct ?
```kotlin
class DragData(	
	runtime: Runtime //this is a jnr.ffi.Runtime
) : Struct(runtime){
    val itemList=StructRef(Item::class.java)
	val itemListLength=Unsigned32()
	val modifireKeyState=Unsigned32()
	val fileSystemId=StructRef(MemBuf::class.java) //map to MemBuf*
	 }
```
+ how to map enum?
```kotlin
enum class NavigationType: EnumMapper.IntegerEnum {
	LINKCLICK,
	FORMSUBMITTE,
	BACKFORWARD,
	RELOAD,
	FORMRESUBMITT,
	OTHER;
	override fun intValue() = ordinal

}
enum class WebDragOperation(val value: Long) {
	None(0),
	Copy(1),
	Link(2),
	Generic(4),
	Private(8),
	Move(16),
	Delete(32),
	Every(0xffffffff);
    override fun intValue() = value.toInt()
    fun longValue()=value
}
```
+ how to map typedef like `typedef wkeWebDragOperation wkeWebDragOperationsMask;`
```kotlin
typealias WebDragOperationsMask=Long //do not  ask me how to do in java...,maybe jdk 11?
```
