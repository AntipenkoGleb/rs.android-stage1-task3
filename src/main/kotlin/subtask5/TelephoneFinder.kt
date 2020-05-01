package subtask5

import java.util.*

class TelephoneFinder {

    private val numbersNeighbors = hashMapOf(
        '0' to arrayListOf('8'),
        '1' to arrayListOf('2', '4'),
        '2' to arrayListOf('1', '3', '5'),
        '3' to arrayListOf('2', '6'),
        '4' to arrayListOf('1', '5', '7'),
        '5' to arrayListOf('2', '4', '6', '8'),
        '6' to arrayListOf('3', '5', '9'),
        '7' to arrayListOf('4', '8'),
        '8' to arrayListOf('0', '5', '7', '9'),
        '9' to arrayListOf('6', '8')
    )

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if(number.contains('-')) return null
        
        val resultList = ArrayList<String>()
        for ((index, char) in number.withIndex()) {
            val newNumber = number.toCharArray()
            for (neighbor in numbersNeighbors[char]!!) {
                newNumber[index] = neighbor
                resultList.add(newNumber.joinToString(""))
            }
        }
        return resultList.toTypedArray()
    }
}
