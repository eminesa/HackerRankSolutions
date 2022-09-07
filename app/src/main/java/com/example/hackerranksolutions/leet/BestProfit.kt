package com.example.hackerranksolutions.leet

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

fun maxProfit(prices: IntArray): Int {
    var minprice = Int.MAX_VALUE
    var maxprofit = 0
    for (i in prices.indices) {
        if (prices[i] < minprice) {
            minprice = prices[i]
        } else if (prices[i] - minprice > maxprofit) {
            maxprofit = prices[i] - minprice
        }
    }
    return maxprofit
}
