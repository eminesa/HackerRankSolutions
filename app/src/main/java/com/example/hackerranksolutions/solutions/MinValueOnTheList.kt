package com.example.hackerranksolutions.solutions


fun main() {
    print(getMinNumberOnList(arrayOf(12,4,3,5,6)))
}

fun getMinNumberOnList(array: Array<Int>): Int{ // it will get me minvalue

    var minValue = array.first()
    array.map {  element ->
        if(element<minValue){
            minValue = element
        }
    }

    return minValue

}