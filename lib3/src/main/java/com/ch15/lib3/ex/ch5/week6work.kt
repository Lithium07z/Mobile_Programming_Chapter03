package com.ch15.lib3.ex.ch5

fun customMapAndFilter(
    inputList: List<Int>,       // 값을 바꾸고 필터링 할 리스트
    mapFun: (Int) -> Int,       // 값을 바꾸는 로직
    filFun: (Int) -> Boolean    // 필터링 로직
): List<Int> {
    
    // 비어 있는 가변 리스트 생성 -> add 함수로 값 추가 가능
    val resultList = mutableListOf<Int>()
    for (i in inputList) {
        if (filFun(mapFun(i))) {
            resultList.add(mapFun(i))
        }
    }

    return resultList
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // 리스트에 담은 값을 모두 제곱한 후, 20보다 작거나 70보다 큰 값만 남도록 필터링
    val result = customMapAndFilter(numbers, {no -> no * no}, {it < 20 || it > 70})

    println("결과: $result")
}