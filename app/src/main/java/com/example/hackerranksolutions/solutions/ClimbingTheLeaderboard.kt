package com.example.hackerranksolutions.solutions

fun main() {

    val result = climbingLeaderboard(arrayOf(100, 100, 50, 40, 40, 20, 10), arrayOf(5, 25, 50, 120))

    println(result.joinToString("\n"))
}

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {

    var scoreList = mutableListOf<Int>()
    val sortedList = mutableListOf<Int>()

    scoreList =
        ranked.distinct().toMutableList()  // sıralamayı almak için aynı olmayan tüm değerleri aldık

    val deneme = scoreList.sorted()  // aldığımız değerleri sıraladık

    for (index in deneme.indices) {
        sortedList.add(deneme[(deneme.size - 1) - index])
    }

    scoreList.clear()
    player.map { playerScore -> // tüm oyuncuların derecesini bilmek için listeyi gezmek zorundayiz

        for (scoreIndex in sortedList.indices) {


        }
    }

    return scoreList.toTypedArray()
}