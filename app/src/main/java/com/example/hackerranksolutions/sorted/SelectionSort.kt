package com.example.hackerranksolutions.sorted

fun main() {

}
fun selectionSort(arr: IntArray) :IntArray {
  val n = arr.size

  // One by one move boundary of unsorted subarray
  for (i in 0 until n - 1) {
    // Find the minimum element in unsorted array
    var minIdx = i
    for (j in i + 1 until n) if (arr[j] < arr[minIdx]) minIdx = j

    // Swap the found minimum element with the first
    // element
    val temp = arr[minIdx]
    arr[minIdx] = arr[i]
    arr[i] = temp
  }
  return arr
}