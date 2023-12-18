package com.example.lib3.ex.ch4.part2.test6

class User(val name: String, val email: String)
data class DataUser(val name: String, val email: String)

fun main() {
    val obj1 = User("kim", "rlawnsghdudw")
    val obj2 = User("kim", "rlawnsghdudw")

    //println("obj1: $obj1, obj2: $obj2")
    //println(obj1.equals(obj2))

    val obj3 = DataUser("kim", "rlawnsghdudw")
    val obj4 = DataUser("kim", "rlawnsghdudw")

    println(obj3.equals(obj4))
}