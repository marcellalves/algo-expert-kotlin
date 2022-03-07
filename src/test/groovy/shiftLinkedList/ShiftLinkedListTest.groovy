package shiftLinkedList

import spock.lang.Specification

class LinkedListTest extends Specification {
    def "should return correct sequence for k = 2"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList linkedList0 = new LinkedList(0)
        LinkedList linkedList1 = new LinkedList(1)
        LinkedList linkedList2 = new LinkedList(2)
        LinkedList linkedList3 = new LinkedList(3)
        LinkedList linkedList4 = new LinkedList(4)
        LinkedList linkedList5 = new LinkedList(5)

        linkedList0.next = linkedList1
        linkedList1.next = linkedList2
        linkedList2.next = linkedList3
        linkedList3.next = linkedList4
        linkedList4.next = linkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(linkedList0, 2)

        then:
        result.value == 4
        result.next.value == 5
        result.next.next.value == 0
        result.next.next.next.value == 1
        result.next.next.next.next.value == 2
        result.next.next.next.next.next.value == 3
        result.next.next.next.next.next.next == null
    }

    def "should return correct sequence for k = -2"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList linkedList0 = new LinkedList(0)
        LinkedList linkedList1 = new LinkedList(1)
        LinkedList linkedList2 = new LinkedList(2)
        LinkedList linkedList3 = new LinkedList(3)
        LinkedList linkedList4 = new LinkedList(4)
        LinkedList linkedList5 = new LinkedList(5)

        linkedList0.next = linkedList1
        linkedList1.next = linkedList2
        linkedList2.next = linkedList3
        linkedList3.next = linkedList4
        linkedList4.next = linkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(linkedList0, -2)

        then:
        result.value == 2
        result.next.value == 3
        result.next.next.value == 4
        result.next.next.next.value == 5
        result.next.next.next.next.value == 0
        result.next.next.next.next.next.value == 1
        result.next.next.next.next.next.next == null
    }

    def "should return correct sequence for k = 8"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList linkedList0 = new LinkedList(0)
        LinkedList linkedList1 = new LinkedList(1)
        LinkedList linkedList2 = new LinkedList(2)
        LinkedList linkedList3 = new LinkedList(3)
        LinkedList linkedList4 = new LinkedList(4)
        LinkedList linkedList5 = new LinkedList(5)

        linkedList0.next = linkedList1
        linkedList1.next = linkedList2
        linkedList2.next = linkedList3
        linkedList3.next = linkedList4
        linkedList4.next = linkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(linkedList0, 8)

        then:
        result.value == 4
        result.next.value == 5
        result.next.next.value == 0
        result.next.next.next.value == 1
        result.next.next.next.next.value == 2
        result.next.next.next.next.next.value == 3
        result.next.next.next.next.next.next == null
    }

    def "should return correct sequence for k = 14"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList linkedList0 = new LinkedList(0)
        LinkedList linkedList1 = new LinkedList(1)
        LinkedList linkedList2 = new LinkedList(2)
        LinkedList linkedList3 = new LinkedList(3)
        LinkedList linkedList4 = new LinkedList(4)
        LinkedList linkedList5 = new LinkedList(5)

        linkedList0.next = linkedList1
        linkedList1.next = linkedList2
        linkedList2.next = linkedList3
        linkedList3.next = linkedList4
        linkedList4.next = linkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(linkedList0, 14)

        then:
        result.value == 4
        result.next.value == 5
        result.next.next.value == 0
        result.next.next.next.value == 1
        result.next.next.next.next.value == 2
        result.next.next.next.next.next.value == 3
        result.next.next.next.next.next.next == null
    }
    def "should return correct sequence for k = -8"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList linkedList0 = new LinkedList(0)
        LinkedList linkedList1 = new LinkedList(1)
        LinkedList linkedList2 = new LinkedList(2)
        LinkedList linkedList3 = new LinkedList(3)
        LinkedList linkedList4 = new LinkedList(4)
        LinkedList linkedList5 = new LinkedList(5)

        linkedList0.next = linkedList1
        linkedList1.next = linkedList2
        linkedList2.next = linkedList3
        linkedList3.next = linkedList4
        linkedList4.next = linkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(linkedList0, -8)

        then:
        result.value == 2
        result.next.value == 3
        result.next.next.value == 4
        result.next.next.next.value == 5
        result.next.next.next.next.value == 0
        result.next.next.next.next.next.value == 1
        result.next.next.next.next.next.next == null
    }
}
