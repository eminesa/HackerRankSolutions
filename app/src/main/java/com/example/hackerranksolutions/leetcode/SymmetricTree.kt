package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {

    // 1,2,2,3,4,4,3
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.right?.right = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right?.left = TreeNode(4)

    println(isSymmetric(root))
}

fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {

    if (left == null && right == null) // tek bir node gelmesi durumunda true döner
        return true

    if (left == null || right == null) // bir node dolu diğerinin null gelmesi durumunda da false döner çünkü simetrik değildir.
        return false

    return (left.`val` == right.`val`) && isMirror(left.left, right.right) && isMirror(
        left.right,
        right.left
    )
}
fun isSymmetric1(root: TreeNode?): Boolean {
    return isMirror(root?.left, root?.right)
}
// time complexity O(n)
// space complexity O(n)

// Queue ile bir çözüm
fun isSymmetric(root: TreeNode?): Boolean {
    val queue: Queue<TreeNode?> = LinkedList()
    queue.add(root)
    queue.add(root)
    while (!queue.isEmpty()) {
        val left = queue.poll()
        val right = queue.poll()
        if (left == null && right == null) continue
        if (left == null || right == null) return false
        if (left.`val` != right.`val`) return false
        queue.add(left.left)
        queue.add(right.right)
        queue.add(left.right)
        queue.add(right.left)
    }
    return true
}

// time complexity O(n)
// space complexity O(n)