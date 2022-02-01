package graphs

class Graph {
    private class Node(private val label: String) {
        override fun toString(): String {
            return label
        }
    }

    private val nodes: MutableMap<String, Node> = mutableMapOf()
    private val adjacencyList: MutableMap<Node, MutableList<Node>> = mutableMapOf()

    fun addNode(label: String) {
        val node = Node(label)
        nodes.putIfAbsent(label, node)
        adjacencyList.putIfAbsent(node, mutableListOf())
    }

    fun addEdge(from: String, to: String) {
        var fromNode = nodes.get(from)
        if(fromNode == null)
            throw IllegalArgumentException()

        var toNode = nodes.get(to)
        if (toNode == null)
            throw IllegalArgumentException()

        adjacencyList.get(fromNode)?.add(toNode)
    }

    fun print(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        for(source in adjacencyList.keys) {
            val targets = adjacencyList.get(source)
            if(targets?.isNotEmpty() == true) {
                for (target in targets) {
                    stringBuilder.append("$source is connected to $target")
                }
            }
        }
        return stringBuilder.toString()
    }
}