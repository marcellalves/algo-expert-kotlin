package graphs

import spock.lang.Specification

class GraphTest extends Specification {
    Graph graph = new Graph()

    def "should add nodes and edges" () {
        when:
        graph.addNode("node1")
        graph.addNode("node2")
        graph.addEdge("node1", "node2")

        then:
        graph.print() == "node1 is connected to node2"
    }
}