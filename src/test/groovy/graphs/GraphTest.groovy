package graphs

import spock.lang.Specification

class GraphTest extends Specification {
    Graph graph = new Graph()

    def "should add nodes and edges" () {
        when:
        graph.addNode("node1")
        graph.addNode("node2")
        graph.addEdge("node1", "node2")
        graph.addNode("node3")
        graph.addEdge("node2", "node3")

        then:
        graph.print() == "node1 is connected to node2" +
                         "node2 is connected to node3"
    }
}