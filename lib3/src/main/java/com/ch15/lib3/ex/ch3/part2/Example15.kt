package com.ch15.lib3.ex.ch3.part2

fun exDownto() {
    var sum: Int = 0
    for (i in 10 downTo 4 step 2) {
        println("$i sum is $sum")
        sum += i
    }
    println(sum)
}
fun exFor()  {
    var data = arrayOf<Int>(10, 20, 30)
    for (i in data.indices) {
        print(data[i])
        if (i != data.size - 1) print("; ")
    }
}

fun main() {
    //exDownto()
    exFor()
}