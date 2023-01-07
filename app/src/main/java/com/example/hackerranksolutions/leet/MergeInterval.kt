package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    //val merge = merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
    val merge = merge(arrayOf(intArrayOf(1, 4), intArrayOf(5, 6))) //[[1,4],[0,1]]
    // val merge = merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 5))) //[[1,4],[0,1]]
    println(merge.joinToString(", "))
}

fun merge12(intervals: Array<IntArray>): Array<IntArray> {

    val mergeList: MutableList<IntArray> = ArrayList()
    val currentInterval = intervals.toMutableList()

    while (currentInterval.isNotEmpty()) {

        var startElement = currentInterval.first()[0]
        var endElement = currentInterval.first()[1]
        currentInterval.removeAt(0)
        var index = 0
        while (index < currentInterval.size) {

            if (endElement >= currentInterval[index][0]) {
                if (endElement < currentInterval[index][1]) {
                    endElement = currentInterval[index][1]
                }
                if (currentInterval[index][0] < startElement && currentInterval[index][1] < startElement) {
                    startElement = currentInterval[index][0]
                }
                currentInterval.removeAt(index)
            } else if (startElement >= currentInterval[index][1]) {
                startElement = currentInterval[index][1]
                currentInterval.removeAt(index)
            }
            index++
        }
        mergeList.add(intArrayOf(startElement, endElement))
    }

    return mergeList.toTypedArray()
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    Arrays.sort(intervals) { a, b -> Integer.compare(a.get(0), b.get(0)) }
    val stack: Stack<IntArray> = Stack()
    stack.add(intervals[0]) //pushing 1st interval

    //2nd interval se compare krenge
    for (i in 1 until intervals.size) {
        val startPoint2 = intervals[i][0] //2nd interval ka start point isliye 2
        val endPoint2 = intervals[i][1]

        //first interval stack mai h toh usse pop kro
        val popArray: IntArray = stack.pop()
        val startPoint1 = popArray[0]
        val endPoint1 = popArray[1]

        //1 3
        //2 6  inko comapre
        val endMax = Math.max(endPoint2, endPoint1)

        if (endPoint1 >= startPoint2) {
            val merge = intArrayOf(startPoint1, endMax)
            stack.add(merge) //merge karne ke baad stack mai dal do
        } else {
            stack.add(popArray)
            stack.add(intervals[i])
        }
    }
    val output = Array(stack.size) { IntArray(2) }

    for (i in output.indices.reversed()) {
        val poparray: IntArray = stack.pop()
        output[i][0] = poparray[0]
        output[i][1] = poparray[1]
    }

    return output
}
