package com.example.hackerranksolutions

fun main() {

    val result = missingNumbers(
        arrayOf(203, 204, 205, 206, 207, 208, 203, 204, 205, 206),
        arrayOf(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204)
    )

    println(result.joinToString(","))

}

fun missingNumbers(arr: Array<Int>, brr: Array<Int>): Array<Int> {

    val foundOneTimeList: MutableList<Int> = brr.toMutableList()

    for (indexOfFirst in arr.indices) {
        for (indexOfSecond in foundOneTimeList.indices) {
            if (arr[indexOfFirst] == foundOneTimeList[indexOfSecond]) {
                foundOneTimeList.remove(arr[indexOfFirst])
                break
            }
        }
    }

    return foundOneTimeList.sorted().distinct().toTypedArray()
}

/*  repeat kullandığımızda içinde filter içinde lsteye ekleme yada çıkarma yapmamıza izin vermiyor.
repeat(arr.size) { indexOfFirst ->
      anArray = foundOneTimeList.filter { indexOfSecond -> arr[indexOfFirst] != indexOfSecond }
  } */