package com.ch15.lib3.ex.ch3.part1


class User
lateinit var user: User
// lateinit var  data3: Int
lateinit var  data4: String

val data5: Int by lazy {
    println("This is in lazy...")
    10
}

fun main() {
    println("This is the main")
    println(data5)
    println(data5)
}