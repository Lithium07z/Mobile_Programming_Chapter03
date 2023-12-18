package com.ch15.lib3.ex.ch3.part1

import java.text.SimpleDateFormat
import java.util.Date

var data = 10

fun formatDate(data: Date): String {
    val sdFormat = SimpleDateFormat("yyyy년MM월dd일")
    return sdFormat.format(data)
}

class Player {
    var name = "hello"

    fun sayHello() {
        println("name: $name")
    }
}