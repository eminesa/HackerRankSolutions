package com.example.hackerranksolutions.solutionclass

fun main() {

    println(birthdayCakeCandles(arrayOf(4, 4, 1, 3)))
    println(birthdayCakeCandles1(arrayOf(4, 4, 1, 3)))

}

fun birthdayCakeCandles(candles: Array<Int>): Int {

    var sum = 0
    var tallest = 0

    for (candle in candles) {
        if (candle > tallest) {
            tallest = candle
        }
    }

    for (candle in candles) {
        if (candle == tallest) sum += 1
    }

    return sum
}

fun birthdayCakeCandles1(candles: Array<Int>): Int {

    var tallest = 0

    candles.map { candle -> if (candle > tallest) tallest = candle }

    return candles.count { candle -> (candle == tallest) }

}
