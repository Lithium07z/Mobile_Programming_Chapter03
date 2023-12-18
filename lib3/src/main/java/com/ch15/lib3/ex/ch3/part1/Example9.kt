package com.ch15.lib3.ex.ch3.part1

fun main() {
    fun someFun(data1: Int = 1, data2: Int = 5):Int {
        return data1 + (2 * data2)
    }

    println(someFun(10, 20))
    println(someFun(data2 = 10, data1 = 20))
    println(someFun(10))
    println(someFun())
}