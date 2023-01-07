package com.example.hackerranksolutions.leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {
println(isValidPalindrome("A man, a plan, a canal: Panama"))
}

fun isValidPalindrome(s: String): Boolean {

    val stack: Stack<Char> = Stack()
    val list: MutableList<Char> = ArrayList()
    val re = Regex("[^A-Za-z0-9 ]")
    val alphabe = re.replace(s, "").toLowerCase().replace(" ", "")

    for (letter in alphabe) {
        stack.add(letter)
        list.add(letter)
    }

    for (index in stack.indices) {
        val stackValue =stack.pop()
        if (stackValue != list[index]) return false
    }

    return true
}