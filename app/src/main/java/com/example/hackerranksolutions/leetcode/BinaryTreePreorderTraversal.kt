package com.example.hackerranksolutions.leetcode

import kotlin.collections.ArrayList

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    val result = preorderTraversal(root)

    println(result.joinToString(", "))
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    val orderList: MutableList<Int> = ArrayList()

    orderList(root, orderList)

    return orderList.toList()
}
