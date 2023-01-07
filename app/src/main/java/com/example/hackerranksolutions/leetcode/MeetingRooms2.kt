package com.example.hackerranksolutions.leetcode

import java.util.*

//[[5,8],[6,8]]
//[[13,15],[]]
//[[2,11],[6,16],[11,16]]
fun main() {
    println(minMeetingRooms3(arrayOf(intArrayOf(2, 11), intArrayOf(6, 16), intArrayOf(11, 16), intArrayOf(11, 16), intArrayOf(11, 16))))
    println(minMeetingRooms(arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))))
    println(minMeetingRooms(arrayOf(intArrayOf(7, 10), intArrayOf(2, 4))))
    println(minMeetingRooms(arrayOf(intArrayOf(5, 8), intArrayOf(6, 8))))
    println(minMeetingRooms(arrayOf(intArrayOf(13, 15), intArrayOf(1, 13))))
    println(minMeetingRooms(arrayOf(intArrayOf(5, 8))))
}


fun minMeetingRooms1(intervals: Array<IntArray>): Int {

    Arrays.sort(intervals) { i1, i2 ->
        i1[0] - i2[0]
    }

    val pq = PriorityQueue<Int>()
    for (element in intervals) {
        val m = element
        if (pq.size == 0 || pq.peek() > m[0]) {
            pq.add(m[0] - 1)
        }
        pq.poll()
        pq.add(m[1])
    }
    return pq.size
}

fun minMeetingRooms3(intervals: Array<IntArray>): Int {

    var usageRoom = 0
    val startArray = mutableListOf<Int>()
    val endArray = mutableListOf<Int>()

    when {
        intervals.isEmpty() -> usageRoom = 0
        intervals.size == 1 -> usageRoom = 1
        else -> {
            for (item in intervals) {
                startArray.add(item[0])
                endArray.add(item[1])
            }

            var itemIndex = 1
            while (itemIndex <= startArray.size) {

                if (itemIndex - 1 == 0) usageRoom += 1

                if (endArray[itemIndex-1] > startArray[itemIndex]) {
                    usageRoom += 1
                }

                if (startArray[itemIndex - 1] >= endArray[itemIndex]) {
                    usageRoom -= 1
                }

                if (startArray.contains(endArray[itemIndex - 1])) {
                    val item =  startArray.indexOf(endArray[itemIndex - 1])
                    startArray.remove(endArray[itemIndex - 1])
                    endArray.remove(item)
                }

                itemIndex += 1
            }
        }
    }
    return usageRoom
}

fun minMeetingRooms(intervals: Array<IntArray>): Int {

    var usageRoom = 0

    when {
        intervals.isEmpty() -> usageRoom = 0
        intervals.size == 1 -> usageRoom = 1
        else -> {

            for (itemIndex in 1 until intervals.size){

                if (itemIndex - 1 == 0) usageRoom += 1

                if (intervals[itemIndex-1][1] > intervals[itemIndex][0]) {
                    usageRoom += 1
                }

                if (intervals[itemIndex][0] >= intervals[itemIndex-1][1]) {
                    usageRoom -= 1
                }
            }
        }
    }
    return usageRoom
}