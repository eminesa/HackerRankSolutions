package com.example.hackerranksolutions.solutions

fun main() {
println(isBalanced("{[()]}"))
println(isBalanced("{[(])}"))
println(isBalanced("{{[[(())]]}}"))

}
// passed just 3 test case
fun isBalanced(s: String): String {

    var isBalanced = true
    val leftSideOfString: String
    val rightsSideOfString: String


    if (s.length % 2 == 1) {
        return "NO"
    } else {

        leftSideOfString = s.substring(0, (s.length/2))
        rightsSideOfString = s.substring(s.length/2, s.length)

        leftSideOfString.mapIndexed { index, brackets ->
            if (brackets+1 == rightsSideOfString[leftSideOfString.length-index-1] || brackets+2 == rightsSideOfString[leftSideOfString.length-index-1]){
                isBalanced = true
            } else{
                return "NO"
            }
        }

    }

    return if (isBalanced) "YES" else "NO"
}