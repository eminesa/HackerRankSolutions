package com.example.hackerranksolutions.leet

fun main() {

}

var i = 0
var p = 0

fun buildTree(pre: IntArray, `in`: IntArray): TreeNode? {
    p = 0
    i = p
    return dfs(pre, `in`, 3001)
}

private fun dfs(pre: IntArray, `in`: IntArray, rightBoundary: Int): TreeNode? {
    if (p == pre.size || `in`[i] == rightBoundary) return null
    val node = TreeNode(pre[p++])
    node.left = dfs(pre, `in`, node.`val`)
    i++
    node.right = dfs(pre, `in`, rightBoundary)
    return node
}