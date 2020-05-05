package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val numbers = itemsFromArray.filterIsInstance<Int>().sortedBy { it.absoluteValue }.toMutableList()
        if (numbers.isEmpty()) return 0

        var sum = 1L
        for (number in numbers) {
            sum *= number
        }

        var numOfDiv = numbers.size - numberOfItems
        while (numOfDiv > 0) {
            val min = if (sum < 0) {
                numbers.removeAt(numbers.indexOfFirst { it < 0 })
            } else {
                numbers.removeAt(numbers.indexOfFirst { numOfDiv >= 1 })
            }
            sum /= min
            numOfDiv--
        }
        return sum.toInt()
    }
}
