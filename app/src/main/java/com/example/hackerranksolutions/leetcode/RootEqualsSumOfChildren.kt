package com.example.hackerranksolutions.leetcode

fun main() {

}

fun checkTree(root: TreeNode?): Boolean {

    val currentRight = root?.right?.`val`
    val currentLeft = root?.left?.`val`

    return root?.`val` == currentRight?.let { currentLeft?.plus(it) }
}
