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
    fun func(someParam:Pointer)
 }
 interface WkeLib{
    fun functionWithCallback(someObject:Pointer,someCallback:SomeCallbackIface)
 }
```
+ how to map struct ?
```kotlin
class DragData(
	val itemList:Array<Item>,
	val itemListLength:Int,
	val modifireKeyState:Int,
	val fileSystemId:MemBuf?, //map to MemBuf*
	runtime: Runtime //this is a jnr.ffi.Runtime
) : Struct(runtime)
```
+ how to map enmus?
```kotlin
enum class NavigationType {
	LINKCLICK,
	FORMSUBMITTE,
	BACKFORWARD,
	RELOAD,
	FORMRESUBMITT,
	OTHER;
	val value get() = ordinal
	companion object {
		fun from(ord: Int) = values().getOrNull(ord)
	}
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
	companion object {
		fun from(ord: Long) = values().find { it.value == ord }
	}
}
```
+ how to map typedef like `typedef wkeWebDragOperation wkeWebDragOperationsMask;`
```kotlin
typealias WebDragOperationsMask=Long //do not  ask me how to do in java...,maybe jdk 11?
```
