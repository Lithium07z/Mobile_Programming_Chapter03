package com.example.lib3.ex.ch5.test1

fun main() {

    //{no: Int -> println(no)}(10)

    val some1 = {no: Int -> println(no)}
    val some2: (Int) -> Unit = {no: Int -> println(no)}
    val some3: (Int) -> Unit = {no -> println(no)}
    // val some4 = {no -> println(no)}

    val some5: (Int) -> Unit = {println(it)}

    some1(10)
    some2(10)

}

