package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.HashMap

fun main() {
 println(allPossibleFBT(7))
}

fun allPossibleFBT(n: Int): List<TreeNode> {
    val memo: MutableMap<Int, List<TreeNode>> = HashMap()
    if (!memo.containsKey(n)) {
        val ans: MutableList<TreeNode> = LinkedList()
        if (n == 1) {
            ans.add(TreeNode(0))
        } else if (n % 2 == 1) {
            for (x in 0 until n) {
                val y = n - 1 - x
                for (left in allPossibleFBT(x)) for (right in allPossibleFBT(y)) {
                    val bns = TreeNode(0)
                    bns.left = left
                    bns.right = right
                    ans.add(bns)
                }
            }
        }
        memo[n] = ans
    }
    return memo[n]!!
}