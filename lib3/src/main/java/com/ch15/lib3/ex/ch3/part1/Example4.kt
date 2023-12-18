package com.ch15.lib3.ex.ch3.part1

val data1 = 10
var data2 = 20
var data3: Any = 10

fun myFun() {
//    data1 = 20
    data2 = 30
}

val roadName: String = "한림대학교"
val address = "$roadName 1"

fun main() {
    println(data3 is Int)
    data3 = "ABCDEF"
    println(data3 is Int)
    println(data3 is String)
    println(roadName is String)
}