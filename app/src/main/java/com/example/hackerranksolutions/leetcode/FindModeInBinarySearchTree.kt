package com.example.hackerranksolutions.leetcode

import kotlin.collections.HashMap

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)

    val result = findMode(root)
    println(result.joinToString(" "))
}

var max = 1
fun findMode(root: TreeNode?): IntArray {
    val map: HashMap<Int, Int> = HashMap()
    findModeBST(root, map)
    val ans = IntArray(map.size) { 0 }
    var idx = 0
    for (key in map.keys) {
        if (map[key] == max) ans[idx++] = key
    }
    return ans.copyOf(idx)
}

private fun findModeBST(root: TreeNode?, map: HashMap<Int, Int>) {
    if (root == null) return
    if (map.containsKey(root.`val`)) {
        val count = map[root.`val`]!! + 1
        map[root.`val`] = count
        max = Math.max(count, max)
    } else map[root.`val`] = 1
    findModeBST(root.left, map)
    findModeBST(root.right, map)
}