package com.example.lib3.ex.ch5.test4

fun multiplier(factor: Int): (Int) -> Int {
//  return { no -> no * factor }
    return {it * factor}
}

fun main() {
    val mulByTwo = multiplier(2)
    val result = mulByTwo(5)
    val result2 = mulByTwo(10)

    val mulByThree = multiplier(3)
    println("${mulByThree(5)}")

    println(result)
    println(result2)
}