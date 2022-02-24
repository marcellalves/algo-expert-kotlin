package linkedLists

import spock.lang.Specification

class ShiftLinkedListTest extends Specification {
    def "should return head from shiftLinkedList"() {
        RunShiftLinkedList runShiftLinkedList = new RunShiftLinkedList()

        given:
        ShiftLinkedList shiftLinkedList1 = new ShiftLinkedList(1)
        ShiftLinkedList shiftLinkedList2 = new ShiftLinkedList(2)
        ShiftLinkedList shiftLinkedList3 = new ShiftLinkedList(3)
        ShiftLinkedList shiftLinkedList4 = new ShiftLinkedList(4)
        ShiftLinkedList shiftLinkedList5 = new ShiftLinkedList(5)

        shiftLinkedList1.next = shiftLinkedList2
        shiftLinkedList2.next = shiftLinkedList3
        shiftLinkedList3.next = shiftLinkedList4
        shiftLinkedList4.next = shiftLinkedList5

        when:
        ShiftLinkedList result = runShiftLinkedList.shiftLinkedListFunction(shiftLinkedList1, 2)

        then:
        result.value == 4
        result.next.value == 5
        result.next.next.value == 0
        result.next.next.next.value == 1
        result.next.next.next.next.value == 2
        result.next.next.next.next.next.value == 3
        result.next.next.next.next.next.next == null
    }
}
