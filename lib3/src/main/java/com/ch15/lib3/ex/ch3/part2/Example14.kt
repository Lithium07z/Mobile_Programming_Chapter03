package com.ch15.lib3.ex.ch3.part2

fun main() {
    var num1: Int = 10
    var num2: Int = 10

    println(num1 == num2)
    println(num1 === num2 )

    var arr = arrayOf<String>("hi")
    arr.set(0, "hello")

    var arr1 = arrayOf<Int>(10, 20)
    var arr2 = arrayOf<Int>(10, 20)

    println("""
        배열에서 연산자 비교
        동등성(==) ${arr1[0] == arr2.get(0)}, ${arr1.get(1) == arr2[1]} 
        동일성(===) ${arr1 === arr2}
    """.trimIndent())
}