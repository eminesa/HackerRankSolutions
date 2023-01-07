package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val result = combinationSum(intArrayOf(2, 3, 6, 7), 7)
    println(result.joinToString("\n"))
}

fun backtrack(
    remain: Int,
    comb: LinkedList<Int?>,
    start: Int, candidates: IntArray,
    results: MutableList<List<Int?>?>
) {
    if (remain == 0) {
        // make a deep copy of the current combination
        results.add(ArrayList<Int>(comb))
        return
    } else if (remain < 0) {
        // exceed the scope, stop exploration.
        return
    }
    for (i in start until candidates.size) {
        // add the number into the combination
        comb.add(candidates[i])
        backtrack(remain - candidates[i], comb, i, candidates, results)
        // backtrack, remove the number from the combination
        comb.removeLast()
    }
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int?>?> {
    val results: MutableList<List<Int?>?> = ArrayList()
    val comb: LinkedList<Int?> = LinkedList()
    backtrack(target, comb, 0, candidates, results)
    return results
}