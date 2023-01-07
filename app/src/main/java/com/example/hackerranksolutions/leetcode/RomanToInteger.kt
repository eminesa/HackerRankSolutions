package com.example.hackerranksolutions.leetcode

fun main() {
   // println(romanToInt("III"))
  //  println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
}
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//

fun romanToInt(s: String): Int {
    val hashMap: HashMap<String, Int> = HashMap()

    hashMap["M"] = 1000
    hashMap["D"] = 500
    hashMap["C"] = 100
    hashMap["L"] = 50
    hashMap["X"] = 10
    hashMap["V"] = 5
    hashMap["I"] = 1

    var sum = 0
    var i = 0
    while (i < s.length) {

        val currentSymbol = s.substring(i, i + 1)
        val currentValue: Int = hashMap[currentSymbol] ?: 0
        var nextValue = 0
        if (i + 1 < s.length) {
            val nextSymbol = s.substring(i + 1, i + 2)
            nextValue = hashMap[nextSymbol] ?: 0
        }
        if (currentValue < nextValue) {
            sum += nextValue - currentValue
            i += 2
        } else {
            sum += currentValue
            i += 1
        }
    }
    return sum
}
