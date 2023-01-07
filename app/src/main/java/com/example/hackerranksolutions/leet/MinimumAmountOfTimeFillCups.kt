package com.example.hackerranksolutions.leet

import java.util.*

fun main() {
    println(fillCups(intArrayOf(5, 4, 4)))
}

fun fillCups(amount: IntArray): Int {
    var seconds = 0
    Arrays.sort(amount) //First sorting the array.
    val highestNum = amount.size - 1
    val secondHighestNum = amount.size - 2
    //Now taking the two biggest numbers of the array which will be at the last and the second last index as the array is sorted.
    while (amount[highestNum] > 0 && amount[secondHighestNum] > 0) {
        //If both these numbers are greater than 0 then we can fill two cups in one second and then decreasing their values.
        amount[highestNum]--
        amount[secondHighestNum]--
        seconds++ //This is one ans
        Arrays.sort(amount) //Now, again sorting using the inbuilt sort of java class so that the biggest two numbers are at the last two index of the array
    }

    //The above loop will break when either of the two places becomes 0
    //If the number at last and secon last index were equal, then both of them will become zero
    //Or if it is not the case, then only one type of water is present in the dispenser
    while (amount[highestNum] > 0) {
        //So, decreasing it one by one till it becomes zero
        amount[highestNum]--
        seconds++
    }
    return seconds //Hence, we have found our answer
}
