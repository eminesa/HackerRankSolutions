package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {

}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val results: MutableList<List<Int>> = ArrayList()
    val comb: LinkedList<Int> = LinkedList()
    Arrays.sort(candidates)
    backtrack(candidates, comb, target, 0, results)
    return results
}

private fun backtrack(
    candidates: IntArray, comb: LinkedList<Int>,
    remain: Int, curr: Int,
    results: MutableList<List<Int>>
) {
    if (remain == 0) {
        // copy the current combination to the final list.
        results.add(ArrayList<Int>(comb))
        return
    }
    for (nextCurr in curr until candidates.size) {
        if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1]) continue
        val pick = candidates[nextCurr]
        // optimization: early stopping
        if (remain - pick < 0) break
        comb.addLast(pick)
        backtrack(candidates, comb, remain - pick, nextCurr + 1, results)
        comb.removeLast()
    }
}
