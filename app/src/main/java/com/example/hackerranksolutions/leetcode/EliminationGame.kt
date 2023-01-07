package com.example.hackerranksolutions.leetcode

fun main() {
    println(lastRemaining(5))
    println(lastRemaining(9))
    println(lastRemaining(1))
}

fun lastRemaining11(n: Int): Int {

    var remainingList: MutableList<Int> = ArrayList()
    for (index in 1..n) {
        remainingList.add(index)
    }
    var isLeft = true

    while (remainingList.size > 1) {
        val size = remainingList.size
        val availableList: MutableList<Int> = ArrayList()

        if (isLeft) {
            for (index in 1 until size step 2) { // 1 2 3 4 5
                availableList.add(remainingList[index])
            }
            remainingList = availableList
            isLeft = false
        } else {
            for (index in 0 until size step 2) {
                availableList.add(remainingList[index])
            }
            remainingList = availableList
            isLeft = true
        }
    }
    return remainingList.first()
}


fun lastRemaining(n: Int): Int {
    var isLeft = true
    var remaining = n
    var step = 1
    var head = 1
    while (remaining > 1) {
        if (isLeft || remaining % 2 == 1) {
            head += step
        }
        remaining /= 2
        step *= 2
        isLeft = !isLeft
    }
    return head
}