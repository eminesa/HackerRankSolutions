package com.example.hackerranksolutions.leet


fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(15)
    root.right?.right = TreeNode(18)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(7)
    println(rangeSumBST(root, 7, 15))
}

private var sum = 0

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    sum = 0
    dfs(root, low, high)
    return sum
}

fun dfs(root: TreeNode?, low: Int, high: Int) {

    if (root != null) {
        if (root.`val` in low..high) {
            sum += root.`val`
        }

        if (low < root.`val`) {
            dfs(root.left, low, high)
        }
        if (root.`val` < high) {
            dfs(root.right, low, high)
        }
    }

}