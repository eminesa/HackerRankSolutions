package com.example.hackerranksolutions.leetcode

import kotlin.collections.ArrayList

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(3)

    val result = binaryTreePaths(root)

    println(result.joinToString("\n"))
}


fun binaryTreePaths(root: TreeNode?): List<String?> {

    if (root == null) return listOf()
    val paths: MutableList<String?> = ArrayList()
    constructPaths(root, StringBuilder(), paths)
    return paths
}

fun constructPaths(root: TreeNode?, path: StringBuilder, paths: MutableList<String?>) {
    val pathWay = StringBuilder(path)

    if (root != null) {
        pathWay.append(root.`val`)
        if (root.left == null && root.right == null) // if reach a leaf
            paths.add(pathWay.toString()) // update paths
        else {
            pathWay.append("->") // extend the current path
            constructPaths(root.left, pathWay, paths)
            constructPaths(root.right, pathWay, paths)
        }
    }
}


// does not work because of catching all path
fun binaryTreePaths12(root: TreeNode?): List<String> {
    if (root == null) return listOf()
    if (root.right == null && root.left == null) return listOf((root.`val`).toString())

    val numberList: MutableList<Int> =
        ArrayList() // cant send list from here it is catch all node sometimes more than one time
    val pathList: MutableList<String> = ArrayList()

    treePath(root, numberList, pathList)

    return pathList
}

fun treePath(root: TreeNode?, numberList: MutableList<Int>, pathList: MutableList<String>) {

    if (root == null) return

    if (root.left == null && root.right == null) {
        val path = StringBuilder()
        for (number in numberList) {
            path.append(number).append("->")
        }
        path.append(root.`val`)
        pathList.add(path.toString())
    } else {
        numberList.add(root.`val`)
    }

    treePath(root.left, numberList, pathList)
    treePath(root.right, numberList, pathList)
}