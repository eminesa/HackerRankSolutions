package com.example.hackerranksolutions.leetcode

fun main() {

    //["a","c","a","b"]
    println(shortestDistance2(arrayOf("practice", "makes", "perfect", "coding", "makes"), "practice", "coding"))
    println(shortestDistance2(arrayOf("practice", "makes", "perfect", "coding", "makes"), "coding", "makes"))
    println(shortestDistance2(arrayOf("a","c","a","b"), "a", "b"))
}

fun shortestDistance1(wordsDict: Array<String>, word1: String, word2: String): Int { // maybe 5

    var minDistWord1 = 0
    var minDistWord2 = 0
    val lookingWord1 = StringBuilder()
    val lookingWord2 = StringBuilder()

    for (word in wordsDict) {

        if (word == word1) {
            if (lookingWord2.isNotEmpty()) lookingWord2.clear()
            lookingWord1.append(word1)
        }
        if (word == word2) {
            if (lookingWord1.isNotEmpty()) lookingWord1.clear()
            lookingWord2.append(word2)
        }
        if (lookingWord1.isNotEmpty()) minDistWord1 += 1
        if (lookingWord2.isNotEmpty()) minDistWord2 += 1
    }

    return if (minDistWord1 < minDistWord2) minDistWord1 else minDistWord2
}

fun shortestDistance2(wordsDict: Array<String>, word1: String, word2: String): Int { // passed 20/27 test case
    val wordHashMap: HashMap<String, String> = HashMap()

    var minDistWord1 = 0
    var minDistWord2 = 0

    for (word in wordsDict) {

        if (word == word1) {
            if (wordHashMap.containsKey(word2)) {
                wordHashMap[word2] = word1
            }
            if (wordHashMap.containsKey(word1)) {
                wordHashMap[word1] = ""
                minDistWord1 = 0
            } else{
                wordHashMap[word1] = ""
            }
        }
        if (word == word2) {
            if (wordHashMap.containsKey(word1)) {
                wordHashMap[word1] = word2
            }
            if (wordHashMap.containsKey(word2)) {
                wordHashMap[word2] = ""
                minDistWord2 = 0
            }else{
                wordHashMap[word2] = ""
            }
        }

        if (wordHashMap[word1] != null && wordHashMap[word1]?.isEmpty() == true) minDistWord1 += 1
        if (wordHashMap[word2] != null && wordHashMap[word2]?.isEmpty() ==true) minDistWord2 += 1

    }

    if (wordHashMap[word1]?.isNotEmpty() == true && wordHashMap[word2]?.isNotEmpty() == true) {
        minDistWord1 = Math.min(minDistWord1, minDistWord2)
    } else {
        minDistWord1 = Math.max(minDistWord1, minDistWord2)
    }

    return minDistWord1
}

fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
    var i1 = -1
    var i2 = -1
    var minDistance = words.size
    for (i in words.indices) {
        if (words[i] == word1) {
            i1 = i
        } else if (words[i] == word2) {
            i2 = i
        }
        if (i1 != -1 && i2 != -1) {
            minDistance = Math.min(minDistance, Math.abs(i1 - i2))
        }
    }
    return minDistance
}
