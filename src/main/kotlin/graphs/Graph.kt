package graphs

import java.util.*

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

    fun traverseDepthFirstRecursive(root: String) {
        val node = nodes.get(root)
        if (node == null) {
            return
        }

        traverseDepthFirstRecursive(node, hashSetOf())
    }

    private fun traverseDepthFirstRecursive(root: Node?, visited: MutableSet<Node>) {
        println(root)
        root?.let { visited.add(it) }

        for (node in adjacencyList.get(root)!!) {
            if (!visited.contains(node)) {
                traverseDepthFirstRecursive(node, visited)
            }
        }
    }

    fun traverseDepthFirstIterative(root: String) {
        val node = nodes.get(root)
        if (node == null) {
            return;
        }

        val visited: MutableSet<Node> = mutableSetOf()

        val stack: Stack<Node> = Stack()
        stack.push(node)

        while (!stack.empty()) {
            val current = stack.pop()

            if (visited.contains(current)) {
                continue
            }

            println(current)
            visited.add(current)

            for (neighbour in adjacencyList.get(current)!!) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour)
                }
            }
        }
    }
}