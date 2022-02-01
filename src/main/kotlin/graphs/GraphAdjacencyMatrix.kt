package graphs

class GraphAdjacencyMatrix// Initialize the matrix
    (private var numVertices: Int) {
    private var adjacencyMatrix: Array<BooleanArray> = Array(numVertices) { BooleanArray(numVertices) }

    fun addEdge (i: Int, j: Int) {
        adjacencyMatrix[i][j] = true
        adjacencyMatrix[j][i] = true
    }

    fun removeEdge (i: Int, j: Int) {
        adjacencyMatrix[i][j] = false
        adjacencyMatrix[j][i] = false
    }

    override fun toString(): String {
        val s = StringBuilder()
        for (i in 0 until numVertices) {
            s.append("$i: ")
            for (j in adjacencyMatrix.get(i)) {
                s.append((if (j) 1 else 0).toString() + " ")
            }
            s.append("\n")
        }
        return s.toString()
    }
}