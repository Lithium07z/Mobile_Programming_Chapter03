package com.ch15.lib3.ex.ch4.part2

open class Super(val name: String) {
    open var superData = 10
    open fun superFun() {
        println("superFun: $superData, name: $name")
    }
}

class Sub(name: String, count: Int, email: String) : Super(name) {
    override var superData = 20
    override fun superFun() {
        println("overrideed superFun: $superData, name: $name")
    }
}

fun main() {
    val obj = Sub("Kim", 10, "rlawnsghdudw@naver.com")
    obj.superFun();
}