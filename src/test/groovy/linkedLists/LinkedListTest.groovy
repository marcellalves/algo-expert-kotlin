package linkedLists

import spock.lang.Specification

class LinkedListTest extends Specification  {
    LinkedList linkedList = new LinkedList()

    def "should add single node at the beginning of the list"() {
        when:
        linkedList.addFirst(1)

        then:
        linkedList.first.value == 1
        linkedList.first.next == null
    }

    def "should add multiple nodes at the beginning of the list"() {
        when:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        then:
        linkedList.first.value == 3
        linkedList.first.next.value == 2
        linkedList.first.next.next.value == 1
        linkedList.first.next.next.next == null
    }

    def "should add single node at the end of the list"() {
        when:
        linkedList.addLast (1)

        then:
        linkedList.last.value == 1
        linkedList.last.next == null
    }

    def "should add multiple nodes at the end of the list"() {
        when:
        linkedList.addLast(1)
        linkedList.addLast(2)
        linkedList.addLast(3)

        then:
        linkedList.first.value == 1
        linkedList.first.next.value == 2
        linkedList.first.next.next.value == 3
        linkedList.first.next.next.next == null
    }

    def "should remove the first node in a multiple node list"() {
        given:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        when:
        linkedList.deleteFirst()

        then:
        linkedList.first.value == 2
        linkedList.first.next.value == 1
        linkedList.first.next.next == null
    }

    def "should remove the first node in a one node list"() {
        given:
        linkedList.addFirst(1)

        when:
        linkedList.deleteFirst()

        then:
        linkedList.first == null
    }

    def "should print the linked list correctly"() {
        when:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        then:
        linkedList.toString() == "3 -> 2 -> 1"
    }
}
