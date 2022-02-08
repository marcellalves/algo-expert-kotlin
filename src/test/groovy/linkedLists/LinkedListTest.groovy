package linkedLists

import spock.lang.Specification

class LinkedListTest extends Specification  {
    LinkedList linkedList = new LinkedList()

    def "should add single node at the beginning of the list"() {
        when:
        linkedList.addFirst(1)

        then:
        linkedList.toString() == "1"
    }

    def "should add multiple nodes at the beginning of the list"() {
        when:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        then:
        linkedList.toString() == "3 -> 2 -> 1"
    }
}
