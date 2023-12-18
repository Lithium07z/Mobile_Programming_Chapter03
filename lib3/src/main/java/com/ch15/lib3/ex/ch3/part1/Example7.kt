package com.ch15.lib3.ex.ch3.part1

fun main() {
    val str1 = "Hello \nWorld"

    val str2 = """
        Hello
        World
    """.trimIndent()

    val str3 = """
         Hello
       World
    """

    println(str1)
    println(str2)
    println(str3)
}