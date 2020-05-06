package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val res = decompose(number.toLong() * number.toLong(), number, mutableListOf()).filterIsInstance<Int>().toTypedArray()
        return if (res.isEmpty()) null else res
    }

    private fun decompose(ost: Long, step: Int, list: MutableList<Any>): List<Any> {
        for (i in step - 1 downTo 1) {
            val max: Long = i.toLong() * i.toLong()
            if (max < ost) {
                val arr = list.toMutableList().apply { add(i) }
                val res = decompose(ost - max, i, arr)
                if (res.contains("LAST")) {
                    list.addAll(res)
                    return res
                }
            }
            if (ost == max) {
                return list.apply {
                    add(i)
                    add("LAST")
                }.reversed()
            }
        }
        return emptyList()
    }
}
