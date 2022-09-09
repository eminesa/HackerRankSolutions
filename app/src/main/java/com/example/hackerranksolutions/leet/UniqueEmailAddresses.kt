package com.example.hackerranksolutions.leet

fun main() {
    println(numUniqueEmails(arrayOf("em.ine+blabla@gmail.com","em.ine@gmail.com")))
}
fun numUniqueEmails(emails: Array<String>): Int {
     // I have to split for local name and domain name from @
    // I will have same size for local and domain name I could be check with this chance

    val hashMapList: HashSet<String> = HashSet()

    for (email in emails) {
        val splitList = email.split("@")
        val name = splitList[0].replace(".", "")
        val currentName = StringBuilder()
        var index = 0
        if (name.contains('+')) {
            while (index < name.length) {
                if (name[index] != '+') {
                    currentName.append(name[index])
                    index++
                } else {
                    index = name.length
                }
            }
        } else {
            currentName.append(name)
        }

        currentName.append("@")
        currentName.append(splitList[1])

        hashMapList.add(currentName.toString())
    }
    return hashMapList.size
}