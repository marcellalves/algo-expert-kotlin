import graphs.Graph

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
    graph.traverseDepthFirst("G")
}