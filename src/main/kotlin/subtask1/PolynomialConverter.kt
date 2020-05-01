package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null;
        var resultString = ""
        for ((index, number) in numbers.reversed().withIndex()) {
            if (number == 0) continue;
            val absNumber = number.absoluteValue

            val sign = if (index == numbers.lastIndex) "" else if (number > 0) " + " else " - "
            val value = if (index == 0) "$absNumber" else if (absNumber == 1) "x" else "${absNumber}x"
            val pow = if (index < 2) "" else "^$index"

            resultString = "$sign$value$pow$resultString"
        }
        return resultString;
    }
}
