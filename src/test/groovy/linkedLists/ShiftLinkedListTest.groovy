package linkedLists

import spock.lang.Specification

class ShiftLinkedListTest extends Specification {
    def "should return correct sequence for positive k"() {
        RunShiftLinkedList runShiftLinkedList = new RunShiftLinkedList()

        given:
        ShiftLinkedList shiftLinkedList0 = new ShiftLinkedList(0)
        ShiftLinkedList shiftLinkedList1 = new ShiftLinkedList(1)
        ShiftLinkedList shiftLinkedList2 = new ShiftLinkedList(2)
        ShiftLinkedList shiftLinkedList3 = new ShiftLinkedList(3)
        ShiftLinkedList shiftLinkedList4 = new ShiftLinkedList(4)
        ShiftLinkedList shiftLinkedList5 = new ShiftLinkedList(5)

        shiftLinkedList0.next = shiftLinkedList1
        shiftLinkedList1.next = shiftLinkedList2
        shiftLinkedList2.next = shiftLinkedList3
        shiftLinkedList3.next = shiftLinkedList4
        shiftLinkedList4.next = shiftLinkedList5

        when:
        ShiftLinkedList result = runShiftLinkedList.shiftLinkedListFunction(shiftLinkedList0, 2)

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
        RunShiftLinkedList runShiftLinkedList = new RunShiftLinkedList()

        given:
        ShiftLinkedList shiftLinkedList0 = new ShiftLinkedList(0)
        ShiftLinkedList shiftLinkedList1 = new ShiftLinkedList(1)
        ShiftLinkedList shiftLinkedList2 = new ShiftLinkedList(2)
        ShiftLinkedList shiftLinkedList3 = new ShiftLinkedList(3)
        ShiftLinkedList shiftLinkedList4 = new ShiftLinkedList(4)
        ShiftLinkedList shiftLinkedList5 = new ShiftLinkedList(5)

        shiftLinkedList0.next = shiftLinkedList1
        shiftLinkedList1.next = shiftLinkedList2
        shiftLinkedList2.next = shiftLinkedList3
        shiftLinkedList3.next = shiftLinkedList4
        shiftLinkedList4.next = shiftLinkedList5

        when:
        ShiftLinkedList result = runShiftLinkedList.shiftLinkedListFunction(shiftLinkedList0, -2)

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
