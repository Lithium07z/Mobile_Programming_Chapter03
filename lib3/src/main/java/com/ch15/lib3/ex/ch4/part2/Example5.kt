package com.example.lib3.ex.ch4.part2.test5

open class Super {
    var publicData = 10
    protected var protectedData = 20
    private  var privateData = 30
}

class Sub : Super() {
    fun subFun() {
        publicData++
        protectedData++
//        privateData++
    }
}

fun main() {
    val obj = Super()
    obj.publicData
//  obj.protectedData++
//  obj.privateData++
}