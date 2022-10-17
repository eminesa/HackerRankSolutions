package com.example.hackerranksolutions.leet

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.right = TreeNode(2)
    root.right = TreeNode(3)
    val result = findMode(root)
    println(result.joinToString(" "))
}

fun findModeKey(root: TreeNode?): IntArray {

    val modeHashMap: HashMap<Int, Int> = HashMap()
    var maxValue = Int.MIN_VALUE
    var keyOfMaxValue = Int.MIN_VALUE

    modeHelperKey(root, modeHashMap)

    modeHashMap.map {
        if (it.value > maxValue){
            maxValue = it.value
            keyOfMaxValue = it.key
        }
    }

    return intArrayOf(keyOfMaxValue)
}

fun modeHelperKey(root: TreeNode?, hashMap: HashMap<Int, Int>) {

    if (root == null) return
    if (hashMap.containsKey(root.`val`)) {
        hashMap[root.`val`] = (hashMap[root.`val`] ?: 0) + 1
    } else {
        hashMap[root.`val`] = 1
    }

    modeHelperKey(root.left, hashMap)

    modeHelperKey(root.right, hashMap)
}