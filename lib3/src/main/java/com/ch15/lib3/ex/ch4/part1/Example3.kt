package com.ch15.lib3.ex.ch4.part1

open class Super(val name: String) {
    var superData = 10
    fun superFun() {
        println("superFun : $superData, name = $name")
    }
}

class Sub(_name: String, count: Int, email: String): Super(_name) {

}

fun main() {
    val obj = Sub("kim", 100, "rlawnsghdudw@naver.com")
    obj.superFun()
}