package com.example.hackerranksolutions.leetcode

import kotlin.collections.HashSet

fun main() {

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    println(closestValue(root, 3.7600))
}

fun closestValue(root: TreeNode?, target: Double): Int {
    if (root == null) return 0
    val set: HashSet<Int> = HashSet()
    findClosest(root, set)

    var closestNode = Int.MAX_VALUE
    for (number in set) {
        if (Math.abs(number-target) < Math.abs(closestNode - target))
            closestNode = number
    }
    return closestNode
}

fun findClosest(root: TreeNode?, set: HashSet<Int>) {
    if (root == null) return

    findClosest(root.left, set)
    set.add(root.`val`)
    findClosest(root.right, set)

}