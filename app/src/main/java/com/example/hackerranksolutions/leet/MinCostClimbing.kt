package com.example.hackerranksolutions.leet

fun main() {
    println(minCostClimbingStairs(intArrayOf(10, 15, 20)))
    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
}

fun minCostClimbingStairs(cost: IntArray): Int {

    // The array's length should be 1 longer than the length of cost
    // This is because we can treat the "top floor" as a step to reach
    val minimumCost = IntArray(cost.size + 1)

    // Start iteration from step 2, since the minimum cost of reaching
    // step 0 and step 1 is 0
    for (i in 2 until minimumCost.size) {
        val takeOneStep = minimumCost[i - 1] + cost[i - 1]
        val takeTwoSteps = minimumCost[i - 2] + cost[i - 2]
        minimumCost[i] = Math.min(takeOneStep, takeTwoSteps)
    }

    // The final element in minimumCost refers to the top floor
    return minimumCost[minimumCost.size - 1]
}


fun minCostClimbingStairs1(cost: IntArray): Int {
    return minimumCost(cost.size, cost)
}

fun minimumCost(i: Int, cost: IntArray): Int {

    val memo = HashMap<Int, Int>()
    // Base case, we are allowed to start at either step 0 or step 1
    if (i <= 1) {
        return 0
    }

    // Check if we have already calculated minimumCost(i)
    if (memo.containsKey(i)) {
        return memo[i]!!
    }

    // If not, cache the result in our hash map and return it
    val downOne = cost[i - 1] + minimumCost(i - 1, cost)
    val downTwo = cost[i - 2] + minimumCost(i - 2, cost)

    memo[i] = Math.min(downOne, downTwo)

    return memo[i]!!
}