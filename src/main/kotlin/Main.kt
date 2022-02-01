import graphs.Graph
import graphs.GraphAdjacencyMatrix

fun main(args: Array<String>) {
    val graph = Graph()
    graph.addNode("A")
    graph.addNode("B")
    graph.addNode("C")
    graph.addNode("D")
    graph.addEdge("A", "B")
    graph.addEdge("B", "D")
    graph.addEdge("D", "C")
    graph.addEdge("A", "C")
    // graph.traverseDepthFirstRecursive("A")
    //graph.traverseDepthFirstIterative("A")

    val adjGraph = GraphAdjacencyMatrix(4)
    adjGraph.addEdge(0, 1)
    adjGraph.addEdge(0, 2)
    adjGraph.addEdge(1, 2)
    adjGraph.addEdge(2, 0)
    adjGraph.addEdge(2, 3)

    println(adjGraph.toString())
}