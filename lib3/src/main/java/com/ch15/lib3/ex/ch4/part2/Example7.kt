package com.example.lib3.ex.ch4.part2.test7

import javax.xml.crypto.Data

data class DataClass(val name: String, val email: String, val age: Int) {
    lateinit var address: String

    constructor(name: String, email: String, age: Int, address: String) : this(name, email, age) {
        this.address = address
    }
}

fun main() {
    val obj1 = DataClass("kim", "rlawnsghdudw@naver.com", 100, "seoul")
    val obj2 = DataClass("kim", "rlawnsghdudw@naver.com", 100, "busan")

    println(obj1.equals(obj2))

    val name = obj1.name
    val email = obj1.email

    val (_name, _email, _age) = obj1

    println("$_name, $_email, $_age")
}