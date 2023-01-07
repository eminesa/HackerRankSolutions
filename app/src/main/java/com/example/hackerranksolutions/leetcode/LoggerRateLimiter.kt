package com.example.hackerranksolutions.leetcode

import kotlin.collections.HashMap

class Logger() {
    private val messageList: HashMap<String, Int> = HashMap()
    private var isShowing:Boolean = false

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {

        if (messageList.containsKey(message)) {
            if (timestamp >= 10.plus(messageList[message] ?: 0)) {
                messageList[message] = timestamp
                isShowing = true
            }else{
                isShowing = false
            }
        } else {
            messageList[message] = timestamp
            isShowing = true
        }

        return isShowing
    }
}

fun main() {
    val logger = Logger()
    println(
        logger.shouldPrintMessage(
            1,
            "foo"
        )
    )  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
    println(
        logger.shouldPrintMessage(
            2,
            "bar"
        )
    )  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
    println(logger.shouldPrintMessage(3, "foo")) // 3 < 11, return false
    println(logger.shouldPrintMessage(8, "bar"))  // 8 < 12, return false
    println(logger.shouldPrintMessage(10, "foo"))// 10 < 11, return false
    println(logger.shouldPrintMessage(11, "foo")) // 11 >= 11, return true, next allowed

}
