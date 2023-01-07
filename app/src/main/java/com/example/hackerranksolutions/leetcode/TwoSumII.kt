package com.example.hackerranksolutions.leetcode

fun main() {
    //val result = twoSum(intArrayOf(2, 7, 11, 13), 9)
    // val result1 = twoSum(intArrayOf(2, 3, 4), 6)
    //val result2 = twoSum(intArrayOf(-1, 0), 1)
    //  println(result.joinToString(" "))
    // println(result1.joinToString(" "))
    // println(result2.joinToString(" "))

    //println(checkRecord("PPALLP"))
    //println(checkRecord("LLL"))
  //  println(checkRecord("LLLALL"))
    println(checkRecord("PPALLL"))
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    val numberSize = numbers.size - 1
    for (i in 0 until numberSize) {
        var j = i + 1
        while (j <= numberSize) {
            if (numbers[i] + numbers[j] == target) {
                return intArrayOf(i + 1, j + 1)
            }
            j++
        }
    }

    return intArrayOf(-1)
}

fun checkRecord(s: String): Boolean {

    val hashMap: HashMap<Char, Int> = HashMap()
    var isMoreThree = false
    hashMap['A'] = 0
    hashMap['L'] = 0
    hashMap['P'] = 0

    for (index in s.indices) {

        when (s[index]) {
            'A' -> {
                hashMap['A'] = hashMap['A']?.plus(1) ?: 1
            }
            'L' -> {
                if (index - 1 >= 0 && s[index - 1] == 'L') {
                    hashMap['L'] = hashMap['L']?.plus(1) ?: 1
                } else {
                    if (hashMap['L']!! >= 3) {
                        isMoreThree = true
                    }
                    hashMap['L'] = 1
                }
            }
            'P' -> {
                hashMap['P'] = hashMap['P']?.plus(1) ?: 1
            }
        }
    }
    return hashMap['A']!! < 2 && !isMoreThree
}