package com.example.hackerranksolutions.leet

fun main() {
   println(numMatchingSubseq("dsahjpjauf", arrayOf("ahjpjau","ja","ahbwzgqnuk","tnmlanowax"))) // not acceptable for all test case
   val solution = Solution()
   solution.numMatchingSubseq("dsahjpjauf", arrayOf("ahjpjau","ja","ahbwzgqnuk","tnmlanowax"))  // passed the hackerrank all test case
}

 class Solution {
    var ca: CharArray = charArrayOf()
    var cb: CharArray = charArrayOf()

    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        var ans = 0
        ca = s.toCharArray()
        for (word in words) if (subseq(word)) ans++
        return ans
    }

    fun subseq(word: String): Boolean {
        var i = 0
        cb = word.toCharArray()
        for (c in ca) {
            if (i < cb.size && c == cb[i]) i++
        }
        return i == cb.size
    }
}



fun numMatchingSubseq(s: String, words: Array<String>): Int {
    var counter = 0

    for (word in words) {
        var index = 0
        val charArray = word.toCharArray()
        var isHave = true
        val checkHashmap = getHashMapList(s)

        while (index < charArray.size) {
            if (checkHashmap[charArray[index].toString()]!= null) {
                checkHashmap[charArray[index].toString()] = (checkHashmap[charArray[index].toString()] ?: 0) - 1
                if (checkHashmap[charArray[index].toString()] == 0){
                    checkHashmap.remove(charArray[index].toString())
                }
            } else {
                index = charArray.size
                isHave = false
            }
            index++
        }

        if (isHave) counter ++

    }

    return counter
}

fun getHashMapList(s: String): HashMap<String, Int> {
    val hashmap: HashMap<String, Int> = hashMapOf()
    s.toCharArray().map { char ->
        if (hashmap[char.toString()] != null) {
            hashmap[char.toString()] =(hashmap[char.toString()] ?: 0) + 1
        } else {
            hashmap[char.toString()] = 1
        }
    }
    return hashmap
}
