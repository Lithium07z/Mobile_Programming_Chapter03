package com.ch15.lib3.ex.ch4.part1

open class parent() {
    var arr: Array<Int> = Array(3, {0})

    constructor(x: Int, y: Int, z: Int): this() {
        arr[0] = x
        arr.set(1, y)
        arr[2] = z
    }

    fun appendArr(num: Int) {
        arr = arr.plus(1)
        arr[3] = num
    }
}

class child(x: Int, y: Int, z: Int, v: Int): parent(x, y, z) {

    init {
        appendArr(v)
    }

    fun printArr() {
        for (i in arr.indices) {
            print(arr[i])
            if (i != arr.size - 1) print(" and ")
        }
    }
}

fun main() {
    val obj = child(10, 20, 30, 40)
    obj.printArr()
}