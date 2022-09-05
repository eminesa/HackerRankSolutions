package com.example.hackerranksolutions.leet

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */
// when I update

fun main() {
    val solution = Solution()

    println(solution.firstBadVersion(7))

}

open class VersionControl() {
    fun isBadVersion(version: Int): Boolean {
        if (version == 4) return true
        return false
    }

}

class Solution : VersionControl() {

    fun firstBadVersion(n: Int): Int {
        var start = 1
        var end = n

        while (start < end) {
            val medium = start + (end - start) / 2
            if (isBadVersion(medium)) {
                end = medium
            } else {
                start = medium + 1
            }
        }
        return start
    }
}