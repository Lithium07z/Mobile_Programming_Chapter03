package com.example.lib3.ex.ch5.test6

fun someFun1(data: String?): Int? {
    return data?.length
}

fun someFun2(data: String?): Int {
    return data?.length ?: 0
}

fun someFun3(data: String?): Int {
    return data!!.length
}

fun main() {

    var data: String? = "kim"
    println("data: $data, size: ${data?.length ?: -1}")

    data = null
    println("data: $data, size: ${data?.length ?: -1}")

    println(someFun1(data))
}