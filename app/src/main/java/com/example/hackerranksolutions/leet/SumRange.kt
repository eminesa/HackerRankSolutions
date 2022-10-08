package com.example.hackerranksolutions.leet

fun main() {
  val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(numArray.sumRange(0,2))

}

class NumArray(nums: IntArray) {
    val numberList = nums

    fun sumRange(left: Int, right: Int): Int {

        var sumRange = 0

        for (index in left..right) {
            sumRange += numberList[index]
        }

        return sumRange
    }

}