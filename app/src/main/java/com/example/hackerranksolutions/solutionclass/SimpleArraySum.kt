package com.example.hackerranksolutions.solutionclass

fun main() {

    println(simpleArraySum(arrayOf(1,2,3,4,5,6)))

    println(simpleArraySum1(arrayOf(1,2,3,4,5,6)))

}

fun simpleArraySum1(ar: Array<Int>): Int {
    var sum = 0

    for(element in ar){
        sum += element
    }

    return sum
}

fun simpleArraySum(ar: Array<Int>): Int  =  ar.sum()