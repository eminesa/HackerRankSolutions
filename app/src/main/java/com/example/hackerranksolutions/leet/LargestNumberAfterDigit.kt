package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    //println(largestInteger(1234))
   // println(largestInteger(65875))
    println(largestInteger(266))
}

fun largestInteger12(num: Int): Int {  //doesnt work clearly
    if (num.toString().length < 2) return num

    val numberAsString: StringBuilder = StringBuilder(num.toString())

    val numberList = IntArray(numberAsString.length)

    for (index in numberList.indices) {
        numberList[index] = numberAsString[index].toString().toInt()
    }

    for (index in numberList.indices) {
        val number = numberList[index]
        val isOdd = number % 2 == 1

        for (j in index + 1 until numberList.size) {
            val value = numberList[j]
            val isAlsoOdd = value % 2 == 1
            if (isOdd && isAlsoOdd && value > number) {
                numberList[index] = value
                numberList[j] = number
            } else if (!isOdd &&  !isAlsoOdd && value > number) {
                numberList[index] = value
                numberList[j] = number
            }

        }

    }
      numberAsString.clear()
       for (number in numberList) {
           numberAsString.append(number)
       }

    return numberAsString.toString().toInt()
}

fun largestInteger(num: Int): Int {
    var number = num
    val oddPriorityQueue: PriorityQueue<Int> = PriorityQueue()
    val evenPriorityQueue: PriorityQueue<Int> = PriorityQueue()
    val bnum = number
  
    while (number > 0) {
        val cur = number % 10
        if (cur % 2 == 1) {
            oddPriorityQueue.add(cur)
        } else {
            evenPriorityQueue.add(cur)
        }
        number /= 10
    }
    
    val sb = java.lang.StringBuilder()
    number = bnum
    while (number > 0) {
        val cur = number % 10
        if (cur % 2 == 1) sb.insert(0, oddPriorityQueue.poll()) else sb.insert(0, evenPriorityQueue.poll())
        number /= 10
    }
    return sb.toString().toInt()
}
