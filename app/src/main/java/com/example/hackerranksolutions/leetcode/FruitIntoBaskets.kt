package com.example.hackerranksolutions.leetcode

import java.util.*

fun main() {
    println(totalFruit(intArrayOf(1, 2, 3, 2, 2)))
}

fun totalFruit(fruits: IntArray): Int {
    val fruitHashMap: HashMap<Int, Int> = HashMap()

    for (fruit in fruits) {
        if (fruitHashMap.containsKey(fruit)) {
            fruitHashMap[fruit] = fruitHashMap[fruit]?.plus(1) ?: 1
        } else {
            fruitHashMap[fruit] = 1
        }
    }

    val list: MutableList<Int> = ArrayList()
    for (fruit in fruitHashMap) {
        list.add(fruit.value)
    }

    Arrays.sort(list.toIntArray())

    var totalFruit: Int? = null
    if (list.size > 1) {
        totalFruit = list[0] + list[1]
    } else if (list.size == 1) {
        totalFruit = list[0]
    }

    return totalFruit ?: 0
}