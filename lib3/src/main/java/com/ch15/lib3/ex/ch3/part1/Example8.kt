package com.ch15.lib3.ex.ch3.part1

fun someFun() {
    var data1: Int = 10
    var data2: Int? = 10
    data2 = null

    class User

    var user1: User? = User()
    user1 = null
}

fun sumFun(no: Int):Int {
    var sum = 0
    for (i in 1..no) {
        sum += i
    }
    return sum
}

fun main() {
    val name = "Kim"

    println("name: $name, sum: ${sumFun(10)}, plus: ${10 + 20}")
//    println("name :" + name + "sum: " + sumFun(10) + "plus: " + (10 + 20))
}