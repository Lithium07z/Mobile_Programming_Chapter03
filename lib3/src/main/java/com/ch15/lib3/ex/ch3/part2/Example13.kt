package com.ch15.lib3.ex.ch3.part2

fun exif() {
    var data: Int = -2

    val result = if (data > 10) {
        println("data > 10")
        true
    } else if (data > 0 && data <= 10) {
        println("data > 0 && data <= 10")
        true
    } else {
        println("data <= 0")
        false
    }

    println(result)
}

fun exWhen1() {
    var data = "kim"
    when (data) {
        "hello" -> println("data is \"hello\"")
        "world" -> println("data is \"world\"")
        else -> {
            println("data is not valid")
        }
    }
}

fun exWhen2(): String {
    var data: Any = "ABC"
    val result = when (data) {
        is String -> "data is String"
        20, 30 -> "data is 20 or 30"
        in 1 .. 10 -> "data is 1..10"
        else -> "data is not valid"
    }

    return result
}

fun main() {
    //exif()
    //exWhen1()
    var str: String = exWhen2()
    println(str)
}