package com.example.hackerranksolutions.solutions


fun main() {

    //miniMaxSum(arrayOf(1,3,5,7,9))
    //miniMaxSum1(arrayOf(1,3,5,7,9))
    miniMaxSum1(arrayOf(256741038, 623958417, 467905213, 714532089, 938071625))

}

fun miniMaxSum(arr: Array<Int>): Unit {

    var min = Long.MAX_VALUE
    var max = 0L
    var sum = 0L

   arr.map { number ->
       sum += number.toLong()
       if (number < min) min = number.toLong()
       if (number > max) max = number.toLong()
   }

    print("${sum - max} ${sum - min}")

    min.toString().replace("AM", "")
    min.toString().replace("PM", "")

}

fun miniMaxSum1(arr: Array<Int>): Unit {

    val sortedList = arr.sorted()

    val min = sortedList.first()
    val max = sortedList.last()

    val sum = arr.sumOf { it.toLong() }

    print("${sum-max} ${sum-min}" )

}