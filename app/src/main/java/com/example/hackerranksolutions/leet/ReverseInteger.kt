package com.example.hackerranksolutions.leet

fun main() {
    println(reverse(123))
    println(reverse(-123))
    println(reverse(120))
}

fun reverse1(x: Int): Int { // Does not work clearly
    val minus = x < 0

    val currentIntCharArray =
        if (minus) x.toString().removeRange(0, 1).toCharArray() else x.toString().toCharArray()
    val reverseInt = StringBuilder()
    val xSize = currentIntCharArray.size - 1

    for (index in xSize downTo 0) {
        reverseInt.append(currentIntCharArray[index])
    }

    if (reverseInt.startsWith("0"))
        reverseInt.removeRange(0, 1)

    return if (minus) -1 * reverseInt.toString().toInt() else reverseInt.toString().toInt()
}

fun reverse(x: Int): Int { // it works
    var currentX = x
    var rev = 0
    while (currentX != 0) {
        val pop = currentX % 10
        currentX /= 10
        if (rev > Int.MAX_VALUE / 10 || rev == Int.MAX_VALUE / 10 && pop > 7) return 0
        if (rev < Int.MIN_VALUE / 10 || rev == Int.MIN_VALUE / 10 && pop < -8) return 0
        rev = rev * 10 + pop
    }
    return rev
}