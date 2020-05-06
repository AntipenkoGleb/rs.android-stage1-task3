package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        return when {
            count % 2 == 0 -> "[]"
            count == 1 -> "[[0]]"
            count == 3 -> "[[0,0,0]]"
            else -> generateBinaryTree("000", 1, count - 3, mutableListOf()).joinToString(
                postfix = "]]",
                prefix = "[[",
                separator = "],["
            ) {
                it.split("").joinToString(",").trim(',').replace("N", "null")

            }
        }
    }

    private fun generateBinaryTree(
        tree: String,
        depth: Int,
        nodesLeft: Int,
        trees: MutableList<String>
    ): MutableList<String> {
        if (nodesLeft == 0) {
            trees.add(tree)
        } else {
            if (tree[depth] == '0') {
                generateBinaryTree(tree + "00", depth + 1, nodesLeft - 2, trees)
                generateBinaryTree(tree + "NN", depth + 1, nodesLeft, trees)
            } else {
                val next = tree.indexOf('0', depth + 1)
                if (next != -1)
                    generateBinaryTree(tree, next, nodesLeft, trees)
            }
        }
        return trees
    }

}
