package com.example.hackerranksolutions.leetcode

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("nbnnnn"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("dvdf"))
    println(lengthOfLongestSubstring("nfpdmpi"))
}

/*fun lengthOfLongestSubstring(s: String): Int {

    val substringList: MutableList<Char> = ArrayList()

    for (letter in s) {
        if (!substringList.contains(letter)) {
            substringList.add(letter)
        }
    }
    return substringList.size
} */

fun lengthOfLongestSubstring(s: String): Int {

    var subString: StringBuilder = StringBuilder()
    var maxLength = 0

    for (letter in s) {
        if (!subString.contains(letter)) {
            subString.append(letter)

        } else {
            for (letterIndex in subString.indices) {
                val removeEnd = letterIndex + 1
                if (subString[letterIndex] == letter) {
                    subString = subString.removeRange(0, removeEnd) as StringBuilder
                    break
                }
            }
            subString.append(letter)
        }
        if (subString.length > maxLength)
            maxLength = subString.length
    }
    return maxLength
}