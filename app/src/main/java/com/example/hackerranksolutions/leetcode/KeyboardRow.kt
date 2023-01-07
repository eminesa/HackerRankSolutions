package com.example.hackerranksolutions.leetcode

fun main() {
    val result = findWords(arrayOf("Hello", "Alaska", "Dad", "Peace"))
    println(result.joinToString(", "))
}

fun findWords(words: Array<String>): Array<String> {

    val hashMap: HashMap<Int, String> = HashMap()
    hashMap[0] = "qwertyuiop"
    hashMap[1] = "asdfghjkl"
    hashMap[2] = "zxcvbnm"

    val rowList: MutableList<String> = ArrayList()

    words.map {
        val currentString = it.toLowerCase()
        val firstElement = currentString.first()
        var rowIndex = 0
        for (index in 0 until hashMap.size) {
            if (hashMap[index]!!.contains(firstElement)) {
                rowIndex = index
                break
            }
        }
        var isSameRow = true
        for (index in 1 until currentString.length) {
            if (!hashMap[rowIndex]!!.contains(currentString[index])) {
                isSameRow = false
                break
            }
        }
        if (isSameRow) rowList.add(it)
    }

    return rowList.toTypedArray()
}