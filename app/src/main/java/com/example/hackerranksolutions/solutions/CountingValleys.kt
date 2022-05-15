package com.example.hackerranksolutions.solutions

fun main() {
    println(countingValleys(8, "UDDDUDUU"))
    println(countingValleys1(8, "UDDDUDUU"))
}

fun countingValleys(steps: Int, path: String): Int {

    var preCount = 0
    var count = 0
    var valley = 0

    val itChar = path.toCharArray() /* gelen string elemanını bir listeye cevirir */

    for (x in 0 until steps) {

        when {
            itChar[x].toString() == "U" -> {
                count += 1
            }
            itChar[x].toString() == "D" -> {
                count -= 1
            }
        }

        if (count == 0 && preCount < count) {
            valley += 1
        }

        preCount = count
    }
    return valley

}

fun countingValleys1(steps: Int, path: String): Int {

    var preCount = 0
    var count = 0
    var valley = 0

    val itChar = path.toCharArray()

     (1..steps).mapIndexed { index, i ->
         when {
             itChar[index] == 'U' -> { /*karakterler tek tirnak ile kontrol edilir. String gibi dusunulmez*/
                 count++
             }
             itChar[index] == 'D' -> {
                 count--
             }
         }
         if (count == 0 && preCount < count) {
             valley++
         }
         preCount = count
     }
    return valley

}
