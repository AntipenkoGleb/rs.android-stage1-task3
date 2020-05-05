package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val (c, n) = array
        var k = 0
        while (getCombinations(n, ++k) < c) {
            if (k + 1 > n) return null
        }
        return k
    }

    private fun getCombinations(n: Int, k: Int): Long {
        return getFactorial(n) / (getFactorial(n - k) * getFactorial(k))
    }

    private fun getFactorial(n: Int): Long {
        var factorial = 1L
        for (i in 1..n) {
            factorial *= i
        }
        return factorial
    }
}
