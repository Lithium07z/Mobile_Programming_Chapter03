package com.ch15.lib3.ex.ch3.part2

fun main() {
    var arr1: Array<Int> = Array(3, {0})
    var arr2 = BooleanArray(3, {false})
    var arr3 = arrayOf<String>("a", "b", "c")
    var arr4 = booleanArrayOf(true, false, true)

    arr1[0] = 10
    arr1[1] = 20
    arr1.set(2, 30)

    arr2.set(2, true)

    println(
        """
            array1 size: ${arr1.size}         
            array1 data: ${arr1[0]}, ${arr1[1]}, ${arr1.get(2)}
        """
    )
}