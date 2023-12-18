package com.ch15.lib3.ex.ch4.part1

class User1(val name: String) {

    init {
        println("in init...")
    }

    constructor(_name: String, count: Int): this(_name) {
        //...
    }

    constructor(__name: String, count: Int, email: String): this(__name, count) {

    }
}

class User2(val name: String, val count: Int) {

    constructor(_name: String): this(_name, 100) {

    }
}

fun main() {
    val u1 = User1("kim", 100, "rlawnsghdudw@naver.com")
}