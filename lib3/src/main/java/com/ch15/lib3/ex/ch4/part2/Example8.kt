package com.example.lib3.ex.ch4.part2.test8

val obj = object {
    var data1 = 20
    fun someFun() {
        data1++
    }
}

open class Super {
    open var data1 = 10
    fun someFun() {
        data1++
    }
}

val obj2 = object : Super() {
    override var data1 = 20
}

fun main() {
    obj2.data1++
}