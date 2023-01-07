package com.example.hackerranksolutions.leetcode

fun main() {
    val satisfiability = Satisfiability()
    println(satisfiability.equationsPossible(arrayOf("a==b", "b!=a")))
    println(satisfiability.equationsPossible(arrayOf("a==b", "b==a")))
}

class Satisfiability {
    fun equationsPossible(equations: Array<String>): Boolean {

        val root = IntArray(26)
        for (i in 0..25) {
            root[i] = i
        }
        for (eqn in equations) {
            if (eqn[1] == '=') {
                val x = eqn[0] - 'a'
                val y = eqn[3] - 'a'
                union(root, x, y)
            }
        }
        for (eqn in equations) {
            if (eqn[1] == '!') {
                val x = eqn[0] - 'a'
                val y = eqn[3] - 'a'
                if (find(root, x) == find(root, y)) return false
            }
        }
        return true
    }

    companion object {
        private fun find(root: IntArray, x: Int): Int {
            if (root[x] != x) root[x] = find(root, root[x])
            return root[x]
        }

        private fun union(root: IntArray, x: Int, y: Int) {
            var currentX = x
            var currentY = y
            currentX = find(root, currentX)
            currentY = find(root, currentY)
            if (currentX != currentY) root[currentX] = currentY
        }
    }
}