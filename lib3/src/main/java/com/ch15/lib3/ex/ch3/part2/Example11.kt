package com.ch15.lib3.ex.ch3.part2

fun main() {
    var list = listOf<Int>(10, 20, 30)
    val mlist = mutableListOf<Int>(10, 20, 30)
    val map = mutableMapOf<String, String>(Pair("one", "hello"), "two" to "world")

    mlist.set(0, 50)
    mlist.add(3, 40)

    map.put("three", "!!")

    println(
        """
            mlist size : ${mlist.size}
            mlist data : ${mlist[0]}, ${mlist.get(1)}, ${mlist.get(2)}, ${mlist.get(3)}
            
            map size : ${map.size}
            map data : ${map.get("one")}, ${map.get("two")}, ${map.get("three")}
        """.trimIndent()
    )
}