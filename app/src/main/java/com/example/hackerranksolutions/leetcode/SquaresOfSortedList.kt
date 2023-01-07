package com.example.hackerranksolutions.leetcode

fun main() {
    val result = sortedSquares1(intArrayOf(-4, 1, 7, 18))

    println(result.joinToString(" "))
}

fun sortedSquares2(nums: IntArray): IntArray { // Time exeption yedik iyi mi :(

    if (nums.isEmpty()) return nums
    val squareList: MutableList<Int> = ArrayList()

    for (numberIndex in nums.indices) {
        val squareNumber = nums[numberIndex] * nums[numberIndex]
        squareList.add(squareNumber)
    }

    val size = squareList.size
    for (i in 0 until size) {
        var minValue = squareList[i]
        var index = i + 1
        while (index < size) {
            if (squareList[index] < minValue) {
                val temporary = squareList[index]
                squareList[index] = minValue
                squareList[i] = temporary
                minValue = temporary
            }
            index++
        }
    }

    return squareList.toIntArray()
}

fun sortedSquares1(nums: IntArray): IntArray { // istedigim sonucu vermiyor.

    if (nums.isEmpty()) return nums
    val squareList: MutableList<Int> = ArrayList()
    val result: MutableList<Int> = ArrayList()

    for (numberIndex in nums.indices) {
        val squareNumber = nums[numberIndex] * nums[numberIndex]
        squareList.add(squareNumber)

        if (result.isEmpty()) {
            result.add(squareNumber)
        } else {
            val minValue = result.last()
            if (squareNumber < minValue) {
                val resultSize = result.size - 1
                result[resultSize] = squareNumber
                result.add(minValue)
            } else {
                result.add(squareNumber)
            }
        }
    }
    return result.toIntArray()
}

fun sortedSquares(nums: IntArray): IntArray { // Sonunda calısan bir cozum
    val n = nums.size
    val result = IntArray(n)
    var left = 0
    var right = n - 1
    for (i in n - 1 downTo 0) {
        var square: Int

        if (Math.abs(nums[left]) < Math.abs(nums[right])) {
            square = nums[right]
            right--
        } else {
            square = nums[left]
            left++
        }
        result[i] = square * square
    }
    return result
}