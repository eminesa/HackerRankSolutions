package com.example.hackerranksolutions.solutions

fun main() {
    println(getTotalX(arrayOf(2, 6), arrayOf(24, 36)))
}

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    var total = 0

    (1..100).map{ index->

        var status = true
        for (element in b) {
            // I used for instead map in this line
            if (element % index != 0) {
                status = false
                break
            }
        }

        if (status) {
            for (element in a) {
                //for the same reason as above
                if (index % element != 0) {
                    status = false
                    break
                }
            }
        }
        if (status) {
            total++
        }
    }
    return total
}

