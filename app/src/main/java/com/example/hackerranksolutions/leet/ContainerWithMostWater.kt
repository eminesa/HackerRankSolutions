package com.example.hackerranksolutions.leet

fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(intArrayOf(1, 1)))
}

fun maxArea1(height: IntArray): Int {

    if (height.size < 2) return 0

    var maxWater = 0

    for (index in height.indices) { // for içinde for kullanmak gerek
        val firstHeight = height[index]
        for (j in index + 1 until height.size) {
            val lastHeight = height[j]
            val currentMaxWater = Math.min(firstHeight, lastHeight) * (j - index)
            if (currentMaxWater > maxWater) {
                maxWater = currentMaxWater
            }
        }

    }
    return maxWater
}
// Time Complexity = O(n^2)
//  O(1)

fun maxArea(height: IntArray): Int {
    if (height.size < 2) return 0
    var maxArea = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        val width = right - left
        maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * width)
        if (height[left] <= height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}
// Time Complexity: O(n)
//Space complexity: O(1)