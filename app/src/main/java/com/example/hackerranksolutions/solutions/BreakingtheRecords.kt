package com.example.hackerranksolutions.solutions

fun main() {

    println(breakingRecords(arrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)))
    println(breakingRecords1(arrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)))

}

fun breakingRecords(scores: Array<Int>): Array<Int> {

    var minScore = if (scores.isNotEmpty()) scores[0] else 0
    var maxScore = if (scores.isNotEmpty()) scores[0] else 0
    var minScoreCounter = 0
    var maxScoreCounter = 0

    for (score in scores) {

        if (score < minScore) {
            minScore = score
            minScoreCounter += 1
        }

        if (score > maxScore) {
            maxScore = score
            maxScoreCounter += 1
        }
    }

    return arrayOf(maxScoreCounter, minScoreCounter)

}

fun breakingRecords1(scores: Array<Int>): Array<Int> {

    var minScore = scores.first()
    var maxScore = scores.first()
    var minScoreCounter = 0
    var maxScoreCounter = 0


    scores.map { score ->
        if (score < minScore) {
            minScore = score
            minScoreCounter += 1
        }

        if (score > maxScore) {
            maxScore = score
            maxScoreCounter += 1
        }
    }

    return arrayOf(maxScoreCounter, minScoreCounter)

}
