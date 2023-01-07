package com.example.hackerranksolutions.leetcode

fun main() {
    println(longestPalindrome("asasabr"))
    println(longestPalindrome("cbbd"))
}

fun longestPalindrome1(s: String): String { //Time Limit Exceeded about n^2

    val longestPalindrome = StringBuilder()
    val longestPalindrome1 = StringBuilder()
    var palindrome = ""
    val size = s.length

    for (letterIndex in 0 until size) {
        palindrome = s[letterIndex].toString().plus(palindrome)
        longestPalindrome1.append(s[letterIndex])

        checkPalindrome(longestPalindrome1, palindrome, longestPalindrome)

        var index = letterIndex + 1
        val longestPalindrome2 = StringBuilder()
        var palindrome2 = ""
        while (index < size) {
            palindrome2 = s[index].toString().plus(palindrome2)
            longestPalindrome2.append(s[index])

            checkPalindrome(longestPalindrome2, palindrome2, longestPalindrome)
            index += 1
        }
    }

    return longestPalindrome.toString()
}

private fun checkPalindrome(
    longestPalindrome1: StringBuilder,
    palindrome: String,
    longestPalindrome: StringBuilder
) {
    if (longestPalindrome1.toString() == palindrome && longestPalindrome.length < palindrome.length) {
        longestPalindrome.clear()
        longestPalindrome.append(palindrome)
    }
}


fun longestPalindrome(s: String?): String? {

    if (s.isNullOrEmpty()) {
        return s
    }

    val len = s.length
    var ans = ""
    var max = 0
    val dp = Array(len) { BooleanArray(len) }
    for (j in 0 until len) {
        for (i in 0..j) {
            val judge = s[i] == s[j]
            dp[i][j] = if (j - i > 2) dp[i + 1][j - 1] && judge else judge
            if (dp[i][j] && j - i + 1 > max) {
                max = j - i + 1
                ans = s.substring(i, j + 1)
            }
        }
    }
    return ans
}