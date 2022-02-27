package linkedLists

open class ShiftLinkedList(var value: Int) {
    var next: ShiftLinkedList? = null
}

class RunShiftLinkedList() {
    fun shiftLinkedListFunction(head: ShiftLinkedList, k: Int): ShiftLinkedList {
        var shifted = mutableListOf<Pair<Int, Int>>()
        var placed = mutableListOf<Int>()
        var currentIndex = -1
        var lastIndex = -1
        var node: ShiftLinkedList? = head

        while (node != null) {
            lastIndex++
            node = node.next
        }

        node = head

        while (node != null) {
            currentIndex++
            var targetIndex = currentIndex + k
            if (targetIndex > lastIndex) {
                targetIndex = targetIndex - lastIndex - 1
            }

            moveNode(node, head, currentIndex, targetIndex, shifted, placed)

            node = node.next
        }

        /*
        for (item in shifted) {
            var targetIndex = item.first + k
            if (targetIndex > lastIndex) {
                targetIndex -= lastIndex
            }
            moveNode(item.second, head, currentIndex, targetIndex, shifted, placed)
        }
        */

        return head
    }

    private fun moveNode(node: ShiftLinkedList, head: ShiftLinkedList, currentIndex: Int, targetIndex: Int, shifted: MutableList<Pair<Int, Int>>, placed: MutableList<Int>) {
        var nodeToBeReplaced: ShiftLinkedList? = null

        if (currentIndex < targetIndex) {
            for (i in currentIndex..targetIndex) {
                if (nodeToBeReplaced == null) {
                    nodeToBeReplaced = node
                } else {
                    nodeToBeReplaced = nodeToBeReplaced.next
                }
            }
        } else {
            for (i in 0..targetIndex) {
                if (nodeToBeReplaced == null) {
                    nodeToBeReplaced = head
                } else {
                    nodeToBeReplaced = nodeToBeReplaced.next
                }
            }
        }

        if (nodeToBeReplaced != null) {
            var oldValue = nodeToBeReplaced.value

            nodeToBeReplaced.value = node.value

            for (pair in shifted) {
                if (pair.first == currentIndex) {
                    nodeToBeReplaced.value = pair.second
                    break
                }
            }

            if (!placed.contains(node.value)) {
                placed.add(node.value)
            }
            shifted.add(Pair(targetIndex, oldValue))
        }
    }
}