package com.ch15.lib3.ex.ch5

fun printResult(operation: (Int, Int) -> Int) {

    val result = operation(2, 3)
    println("Result: $result")
}

fun main() {
    printResult {x, y -> x + y}
}