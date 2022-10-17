package com.example.hackerranksolutions.leet

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    println(findTarget(root, 5))
}

fun findTarget12(root: TreeNode?, k: Int): Boolean {

    if (root == null) return false
    // by the way you learned English language
    // I have a root it is a tree I will check in the root two node sum == target
    // if target == tow sum node return true else false

    return sumOfTwo(root.right, k) || sumOfTwo(root.left, k)
}

fun sumOfTwo(firstRoot: TreeNode?, target: Int?): Boolean {

    if (firstRoot == null) return false

    if (firstRoot.right != null) {
        if (firstRoot.`val` + firstRoot.right!!.`val` == target) return true
        sumOfTwo(firstRoot.right?.right, target)
    }

    if (firstRoot.left != null) {

        if (firstRoot.`val` + firstRoot.left!!.`val` == target) return true
        sumOfTwo(firstRoot.left?.left, target)
    }

    return false
}

fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set: MutableSet<Int?> = HashSet()
    return find(root, k, set)
}

fun find(root: TreeNode?, k: Int, set: MutableSet<Int?>): Boolean {
    if (root == null) return false
    if (set.contains(k - root.`val`)) return true
    set.add(root.`val`)
    return find(root.left, k, set) || find(root.right, k, set)
}