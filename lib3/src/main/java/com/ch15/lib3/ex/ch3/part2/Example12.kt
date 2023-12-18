package com.ch15.lib3.ex.ch3.part2

fun opFun1(num1: Int, num2: Int, num3: Int) {
    var x = num1
    var y = num2
    var z = num3

    x += 2 // x = x + 2
    y -= 5 // y = y - 5
    z %= 4 // z = z % 4

    println("$x, $y, $z")
}

fun opFun2(num1: Int, num2: Int) {
    println("""
        > ${num1 > num2}
        >= ${num1 >= num2}
        == ${num1 == num2}
        != ${num1 != num2}
    """.trimIndent())
}

fun opFun3(data1: Boolean, data2: Boolean) {
    println("""
        && ${data1 && data2}
        || ${data1 || data2}
        ! ${!data1}, ${!data2}
    """.trimIndent())
}

fun main() {
    //opFun1(10, 20, 30)
    //opFun2(10, 10)
    opFun3(10 == 10, 20 > 10)
}