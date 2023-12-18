package com.example.lib3.ex.ch4.part2.test9

class MyClass {

    var data = 10
    companion object {
        var data1 = 20
        fun someFun() {
            println(data1)
        }
    }
}

fun main() {
    //MyClass.data
    val obj = MyClass()
    obj.data

    MyClass().data

    MyClass.data1
    MyClass.someFun()
}