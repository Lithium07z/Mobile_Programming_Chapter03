package com.ch15.lib3.ex.ch3.part1

fun main() {
    val id: Int by lazy {
        println("id 이용 확인 (by lazy)")
        20195138
    }

    println("""
        3주차 과제
        확인문구는
        아래와 같습니다.
    """)

    println(doingHwChapter3(925, id))
}

fun doingHwChapter3(code: Int, id: Int, name: String = "김준호"): String {
    println("입력코드: ${code}, 학번 / 이름: ${id} / ${name}")
    return "출력 완료."
}