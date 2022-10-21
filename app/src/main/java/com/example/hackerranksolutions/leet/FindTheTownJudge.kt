package com.example.hackerranksolutions.leet


fun main() {
    println(findJudge(2, arrayOf(intArrayOf(1, 2))))
    println(findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
    println(findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1))))
    println(findJudge(4, arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(4,3))))
}

fun findJudge1(n: Int, trust: Array<IntArray>): Int { // does not work

    for (node in trust) {
        if (node[1] != n) return -1
    }

    return n
}

fun findJudge12(N: Int, arr: Array<IntArray>): Int {
    val trust = IntArray(N)
    val trusted = IntArray(N)

    for (i in arr.indices) {
        val a = arr[i][0]
        val b = arr[i][1]
        trust[a - 1]++
        trusted[b - 1]++
    }
    for (i in 0 until N) {
        if (trust[i] == 0 && trusted[i] == N - 1) return i + 1
    }
    return -1
}

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val count = IntArray(n + 1)
    for (t in trust) {
        count[t[0]]--
        count[t[1]]++
    }
    for (i in 1..n) {
        if (count[i] == n - 1) return i
    }
    return -1
}