package com.ch15.lib3.ex.test

lateinit var late: String
val lz: Int by lazy {
    10
}

fun main() {
    var arr1: Array<Int> = Array(10, {0})
    var arr2 = Array(10, {0})
    var arr3 = arrayOf(1, 2, 3)
    var arr4 = booleanArrayOf(true, false, true)
    var arr5 = Array(10, {""})

    var list1: List<Int> = List(10, {0})
    var list2 = List<Int>(10, {0})
    var list3 = listOf(1, 2, 3)
    var list4 = mutableListOf(1, 2, 3)

    var map1: Map<String, String>
    var map2: MutableMap<String, Int>
    var map3 = mapOf(Pair("A", "B"), Pair("C", "D"))
    var map4 = mapOf("E" to "F", "G" to "H")
    var map5 = mutableMapOf(Pair("A", 0), Pair("B", 1))

    for (i in 1..10) println(i) // 1부터 10까지
    for (i in 1 until 10) println(i) // 1부터 9까지
    for (i in 2..10 step 2) println(i) // 2부터 10까지 2씩 증가
    for (i in 10 downTo 1) println(i) // 10에서 1까지 1씩 감소

    for (i in arr3.indices) {
        println(arr3[i])
    }

    for ((index, value) in arr3.withIndex()) {
        println("index : $index, value : $value")
    }

}

fun temp() {

}


