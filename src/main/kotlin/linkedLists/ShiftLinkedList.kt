package linkedLists

open class ShiftLinkedList(var value: Int) {
    var next: ShiftLinkedList? = null
}

class RunShiftLinkedList() {
    fun shiftLinkedListFunction(head: ShiftLinkedList, k: Int): ShiftLinkedList {
        var shifted = mutableListOf<Pair<Int,ShiftLinkedList>>()
        var placed = mutableListOf<Int>()
        var currentIndex = 0
        var lastIndex = -1
        var node: ShiftLinkedList? = head

        while (node != null) {
            lastIndex++
            node = node.next
        }

        node = head

        while (node != null) {
            var targetIndex = currentIndex + k
            if (targetIndex > lastIndex) {
                targetIndex = targetIndex - lastIndex
            }
            moveNode(node, currentIndex, targetIndex, shifted, placed)

            currentIndex++
            node = node.next
        }

        for (item in shifted) {
            var targetIndex = item.first + k
            if (targetIndex > lastIndex) {
                targetIndex -= lastIndex
            }
            moveNode(item.second, currentIndex, targetIndex, shifted, placed)
        }

        return head
    }

    private fun moveNode(node: ShiftLinkedList, currentIndex: Int, targetIndex: Int, shifted: MutableList<Pair<Int, ShiftLinkedList>>, placed: MutableList<Int>) {
        var nodeToBeReplaced: ShiftLinkedList? = null

        for(i in currentIndex..targetIndex - 1) {
            if (nodeToBeReplaced == null) {
                nodeToBeReplaced = node.next
            } else {
                nodeToBeReplaced = nodeToBeReplaced.next
            }
        }

        if (nodeToBeReplaced != null && !placed.contains(nodeToBeReplaced.value)) {
            placed.add(node.value)
            shifted.add(Pair(targetIndex, nodeToBeReplaced))
        }
    }
}