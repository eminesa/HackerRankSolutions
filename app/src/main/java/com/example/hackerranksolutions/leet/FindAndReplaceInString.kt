package com.example.hackerranksolutions.leet

fun main() {
    println(findReplaceString("abcd", intArrayOf(0, 2), arrayOf("a", "cd"), arrayOf("eee", "ffff") ))
}

fun findReplaceString(
    s: String,
    indices: IntArray,
    sources: Array<String>,
    targets: Array<String?>
): String {
    val len = s.length
    val ar = arrayOfNulls<String>(len)

    // initialize ar[] with just a single character from s
    for (i in 0 until len) {
        ar[i] = s[i].toString()
    }

    for (i in sources.indices) {

        // use s.substring(...) instead of s.indexof(...) so that the search does not go beyond the length of sources[i]
        if (indices[i] + sources[i].length <= len && s.substring(
                indices[i],
                indices[i] + sources[i].length
            ) == sources[i]
        ) {
            ar[indices[i]] = targets[i]

            // replace the next
            for (k in 1 until sources[i].length) {
                ar[indices[i] + k] = ""
            }
        }
    }

    // combine all into a single string
    val sb = StringBuilder()
    for (i in ar.indices) {
        sb.append(ar[i])
    }
    return sb.toString()
}