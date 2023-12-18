package com.example.lib3.ex.ch5.test2


fun hofFun(arg: (Int) -> Boolean): () -> String {

    val result = if(arg(10)) { // arg(10) .. return 10 > 10
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result: $result"}
}

fun hofFun2(no: Int, arg: (Int) -> Boolean): () -> String {
    //...
    return {"hofFun2"}
}

fun main() {
    val result = hofFun({no -> no > 10}) // arg = {no: Int -> no > 10}
    println(result())

    val result2 = hofFun({it > 20})
    println(result2())

    val result3 = hofFun {it > 20}
    println(result3())

    val result4 = hofFun2(10, {it > 20})
    val result5 = hofFun2(10) {it > 20}
    // val result5 = hofFun2 10, {it > 20}
}