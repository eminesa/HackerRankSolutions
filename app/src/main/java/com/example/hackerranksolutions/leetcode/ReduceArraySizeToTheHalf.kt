package com.example.hackerranksolutions.leetcode

import kotlin.math.absoluteValue

fun main() {
    println(minSetSize(intArrayOf(3, 3, 3, 5, 2, 2,2, 7)))
}

fun minSetSize(arr: IntArray): Int {

    var removedArraySize = 1
    val hashmap: HashMap<Int, Int> = hashMapOf()
    val listOfAll = mutableListOf<Int>()

    for (element in arr) {
        if (hashmap.containsKey(element)) {
            hashmap[element] = hashmap[element]?.absoluteValue?.plus(1) ?: 0
        } else {
            hashmap[element] = 1
        }
    } //O(n) time complexity

    for (item in hashmap) {
        listOfAll.add(item.value)
    } //O(n) time complexity

    val sortedList = listOfAll.sorted()
    var total :Int = 0
    for (index in sortedList.size-1 downTo 0){
        total += sortedList[index]
        if (total < arr.size / 2 ){
            removedArraySize++
        }else{
            break
        }
    } //O(n) time complexity

    return removedArraySize
}
