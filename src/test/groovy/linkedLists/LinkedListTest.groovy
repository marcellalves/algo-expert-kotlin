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
        linkedList.last == null
    }

    def "should remove the last node in a multiple node list"() {
        given:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        when:
        linkedList.deleteLast()

        then:
        linkedList.first.value == 3
        linkedList.first.next.value == 2
        linkedList.first.next.next == null
    }

    def "should remove the last node in a one node list"() {
        given:
        linkedList.addFirst(1)

        when:
        linkedList.deleteLast()

        then:
        linkedList.first == null
        linkedList.last == null
    }

    def "should return true if a list with multiple nodes contains a value at the first node of the list"() {
        given:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        when:
        Boolean result = linkedList.contains(1)

        then:
        result
    }

    def "should return true if a list with multiple nodes contains a value at the middle of the list"() {
        given:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        when:
        Boolean result = linkedList.contains(2)

        then:
        result
    }

    def "should return true if a list with multiple nodes contains a value at the end of the list"() {
        given:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        when:
        Boolean result = linkedList.contains(3)

        then:
        result
    }

    def "should return true if a list with a single node contains a value"() {
        given:
        linkedList.addFirst(1)

        when:
        Boolean result = linkedList.contains(1)

        then:
        result
    }

    def "should return false if a list with multiple nodes does not contain a value"() {
        given:
        linkedList.addFirst(1)
        linkedList.addFirst(2)
        linkedList.addFirst(3)

        when:
        Boolean result = linkedList.contains(4)

        then:
        !result
    }

    def "should return false if a list with a single node does not contain a value"() {
        given:
        linkedList.addFirst(1)

        when:
        Boolean result = linkedList.contains(2)

        then:
        !result
    }

    def "should return the index of a value at the beginning of a multiple node list"() {
        given:
        linkedList.addFirst(3)
        linkedList.addFirst(2)
        linkedList.addFirst(1)

        when:
        Integer result = linkedList.indexOf(1)

        then:
        result == 0
    }

    def "should return the index of a value at the middle of a multiple node list"() {
        given:
        linkedList.addFirst(3)
        linkedList.addFirst(2)
        linkedList.addFirst(1)

        when:
        Integer result = linkedList.indexOf(2)

        then:
        result == 1
    }

    def "should return the index of a value at the end of a multiple node list"() {
        given:
        linkedList.addFirst(3)
        linkedList.addFirst(2)
        linkedList.addFirst(1)

        when:
        Integer result = linkedList.indexOf(3)

        then:
        result == 2
    }

    def "should return the index of a value in a one node list"() {
        given:
        linkedList.addFirst(1)

        when:
        Integer result = linkedList.indexOf(1)

        then:
        result == 0
    }

    def "should return -1 as index if a value does not exist at a multiple node list"() {
        given:
        linkedList.addFirst(3)
        linkedList.addFirst(2)
        linkedList.addFirst(1)

        when:
        Integer result = linkedList.indexOf(4)

        then:
        result == -1
    }

    def "should return -1 as index if a value does not exist at a one node list"() {
        given:
        linkedList.addFirst(1)

        when:
        Integer result = linkedList.indexOf(2)

        then:
        result == -1
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
