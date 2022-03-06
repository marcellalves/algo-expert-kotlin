package shiftLinkedList

import spock.lang.Specification

class LinkedListTest extends Specification {
    def "should return correct sequence for positive k"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList shiftLinkedList0 = new LinkedList(0)
        LinkedList shiftLinkedList1 = new LinkedList(1)
        LinkedList shiftLinkedList2 = new LinkedList(2)
        LinkedList shiftLinkedList3 = new LinkedList(3)
        LinkedList shiftLinkedList4 = new LinkedList(4)
        LinkedList shiftLinkedList5 = new LinkedList(5)

        shiftLinkedList0.next = shiftLinkedList1
        shiftLinkedList1.next = shiftLinkedList2
        shiftLinkedList2.next = shiftLinkedList3
        shiftLinkedList3.next = shiftLinkedList4
        shiftLinkedList4.next = shiftLinkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(shiftLinkedList0, 2)

        then:
        result.value == 4
        result.next.value == 5
        result.next.next.value == 0
        result.next.next.next.value == 1
        result.next.next.next.next.value == 2
        result.next.next.next.next.next.value == 3
        result.next.next.next.next.next.next == null
    }

    def "should return correct sequence for negative k"() {
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList()

        given:
        LinkedList shiftLinkedList0 = new LinkedList(0)
        LinkedList shiftLinkedList1 = new LinkedList(1)
        LinkedList shiftLinkedList2 = new LinkedList(2)
        LinkedList shiftLinkedList3 = new LinkedList(3)
        LinkedList shiftLinkedList4 = new LinkedList(4)
        LinkedList shiftLinkedList5 = new LinkedList(5)

        shiftLinkedList0.next = shiftLinkedList1
        shiftLinkedList1.next = shiftLinkedList2
        shiftLinkedList2.next = shiftLinkedList3
        shiftLinkedList3.next = shiftLinkedList4
        shiftLinkedList4.next = shiftLinkedList5

        when:
        LinkedList result = shiftLinkedList.shiftLinkedList(shiftLinkedList0, -2)

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
