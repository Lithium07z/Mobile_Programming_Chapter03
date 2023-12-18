package com.ch15.lib3.ex.ch3.part1

fun main() {
    var data1: Int = 10
    var data2: Int? = null

    println(data1.plus(10))
    println(data1.plus(0.1f))

    println(data1.plus(0.1f) is Float)
}