package com.example.hackerranksolutions.leet

import java.util.*
import kotlin.collections.HashSet

fun main() {

}

fun openLock(deadends: Array<String>, target: String): Int {

    val dead: MutableSet<String> = HashSet()
    for (d in deadends) dead.add(d)

    val queue: Queue<String> = LinkedList()
    queue.offer("0000")
    queue.offer(null)
    val seen: MutableSet<String> = HashSet()
    seen.add("0000")
    val depth = 0
    while (queue.isNotEmpty()) {
        val node: String = queue.poll() as String
        if (node == target) {
            return depth
        } else if (!dead.contains(node)) {
            for (i in 0..3) {
                var d = -1
                while (d <= 1) {
                    val y = (node[i] - '0' + d + 10) % 10
                    val nei = node.substring(0, i) + ("" + y) + node.substring(i + 1)
                    if (!seen.contains(nei)) {
                        seen.add(nei)
                        queue.offer(nei)
                    }
                    d += 2
                }
            }
        }
    }
    return -1
}
