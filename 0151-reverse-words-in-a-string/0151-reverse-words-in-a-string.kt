class Solution {

    fun reverseWords(s: String): String {
      
        val splitList= s.split(" ").filter { it.isNotBlank() }

        val reverseString : StringBuilder = StringBuilder()

        val listSize = splitList.size - 1
        for(index in listSize downTo 0){
           
           if(index != 0 ) {
         reverseString.append(splitList[index]).append(" ")
         }
           else{
             reverseString.append(splitList[index])
           }     

    }
     return reverseString.toString()
    }

}