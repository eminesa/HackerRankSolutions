package com.example.hackerranksolutions.solutions

fun main() {
    // println(towerBreakers(2,2))
    // println(towerBreakers(1,7))
    // println(towerBreakers(3,7))
    println(towerBreakers(1, 4))
    println(towerBreakers1(1, 4))

}

fun towerBreakers(n: Int, m: Int): Int {
// this solution is correct just for one case
    var winner = 1
    var tower = n

    while (tower > 1) {

        when (winner) {
            1 -> {
                winner = 2
            }
            2 -> {
                winner = 1
            }
        }

        tower /= n
    }
    return winner

}

fun towerBreakers1(n: Int, m: Int): Int {

    // if height == 1, the game is immediately over
    //     => p.1 has no moves; p.2 wins
    // if towers are divisible by 2,
    //     => 2 mimics p.1's moves; p.2 wins
    return if (n % 2 == 0 || m == 1) 2 else 1

    // otherwise, if towers is odd, p.1 can
    // take the first tower down to 1, effectively
    // making themselves p.2 and the tower numbers even,
    // which means they are now in the position to mimic
    // the original p.2's moves for the remaining towers
    // and win the game
    //    => the original p.1 wins

}
