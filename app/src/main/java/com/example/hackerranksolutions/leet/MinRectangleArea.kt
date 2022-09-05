package com.example.hackerranksolutions.leet

fun main() {
    println(
        minAreaRect(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 3),
                intArrayOf(3, 1),
                intArrayOf(3, 3),
                intArrayOf(2, 2),
            )
        )
    )
}

fun minAreaRect(points: Array<IntArray>): Int {

    if (points.size < 4) return 0
    val pointSet: MutableSet<Int> = HashSet()
    for (point in points) pointSet.add(40001 * point[0] + point[1])
    var ans = Int.MAX_VALUE
    for (i in points.indices) for (j in i + 1 until points.size) {
        if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
            if (pointSet.contains(40001 * points[i][0] + points[j][1]) &&
                pointSet.contains(40001 * points[j][0] + points[i][1])
            ) {
                ans = Math.min(
                    ans,
                    Math.abs(points[j][0] - points[i][0]) * Math.abs(points[j][1] - points[i][1])
                )
            }
        }
    }
    return if (ans < Int.MAX_VALUE) ans else 0
}