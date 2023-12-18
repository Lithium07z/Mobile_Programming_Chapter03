package com.example.lib3.ex.ch5.test3

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main() {
    val sum = calculate(5, 3) {x, y -> x + y}
    //val sum = calculate(5, 3, {x, y -> x + y})
    val mul = calculate(5, 3) {x, y -> x * y}

    println("합계: $sum, 곱: $mul")
}
