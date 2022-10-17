package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    highFive(
        arrayOf(
            intArrayOf(1, 90),
            intArrayOf(1, 91),
            intArrayOf(1, 95),
            intArrayOf(1, 100),
            intArrayOf(1, 65),
            intArrayOf(2, 90),
            intArrayOf(2, 30),
            intArrayOf(2, 89),
            intArrayOf(2, 70),
            intArrayOf(2, 90),
        )
    )
}

fun highFive12(items: Array<IntArray>): Array<IntArray> {

    val scoreHashMap: HashMap<Int, MutableList<Int>> = HashMap()
    val scoreList: MutableList<IntArray> = ArrayList()

    for (item in items) {
        if (scoreHashMap.containsKey(item[0])) {
            scoreHashMap[item[0]]?.add(item[1])
        } else {
            scoreHashMap[item[0]] = mutableListOf(item[1])
        }
    }

    for (hashmap in scoreHashMap) {
        var avarage = 0
        val newList = hashmap.value.toList().sorted()

        val listSize = hashmap.value.size - 1
        var divisorSize = 5
        if (listSize > 4) {
            for (index in listSize downTo listSize - 5) {
                avarage += newList[index]
            }
        } else {
            divisorSize = listSize
            for (index in 0 until listSize) {
                avarage += hashmap.value[index]
            }
        }
        scoreList.add(intArrayOf(hashmap.key, avarage / divisorSize))
    }

    return scoreList.toTypedArray()
}


fun highFive(items: Array<IntArray>): Array<IntArray> {
   val divisor = 5
    val allScores: TreeMap<Int, Queue<Int>> = TreeMap()
    for (item in items) {
        val id = item[0]
        val score = item[1]
        if (!allScores.containsKey(id)) allScores[id] = PriorityQueue()
        // insert the score in the min heap
        allScores[id]?.add(score)
        // remove the minimum element from the min heap in case the size of the min heap exceeds 5
        if (allScores[id]!!.size > divisor) allScores[id]?.poll()
    }
    val solution: MutableList<IntArray> = ArrayList()
    for (id in allScores.keys) {
        var sum = 0
        // min heap contains the top 5 scores
        for (i in 0 until divisor) sum += allScores[id]?.poll() ?: 0
        solution.add(intArrayOf(id, sum / divisor))
    }

    return solution.toTypedArray()
}