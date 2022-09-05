package com.example.hackerranksolutions.leet

fun main() {
    val deneme = sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))

    println(deneme)
}

fun helper(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) return null

    // always choose left middle node as a root
    val p = (left + right) / 2

    // preorder traversal: node -> left -> right
    val root = TreeNode(nums[p])
    root.left = helper(nums, left, p - 1)
    root.right = helper(nums, p + 1, right)
    return root
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {

    return helper(nums, 0, nums.size - 1)
}