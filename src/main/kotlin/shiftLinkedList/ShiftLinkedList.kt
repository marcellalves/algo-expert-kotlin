package shiftLinkedList

open class LinkedList(var value: Int) {
    var next: LinkedList? = null
}

class ShiftLinkedList {
    fun shiftLinkedList(head: LinkedList, k: Int): LinkedList {
        val shifted = mutableListOf<Pair<Int, Int>>()
        var currentIndex = -1
        var lastIndex = -1
        var node: LinkedList? = head

        while (node != null) {
            lastIndex++
            node = node.next
        }

        node = head

        while (node != null) {
            currentIndex++

            var targetIndex: Int
            if (k > 0) {
                targetIndex = currentIndex + k
            } else {
                targetIndex = lastIndex + k + currentIndex + 1
            }

            if (targetIndex > lastIndex) {
                targetIndex = targetIndex - lastIndex - 1
            }

            moveNode(node, head, currentIndex, targetIndex, shifted)

            node = node.next
        }

        return head
    }

    private fun moveNode(
        node: LinkedList,
        head: LinkedList,
        currentIndex: Int,
        targetIndex: Int,
        shifted: MutableList<Pair<Int, Int>>
    ) {
        var nodeToBeReplaced: LinkedList? = null

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
            val oldValue = nodeToBeReplaced.value

            nodeToBeReplaced.value = node.value

            for (pair in shifted) {
                if (pair.first == currentIndex) {
                    nodeToBeReplaced.value = pair.second
                    break
                }
            }

            shifted.add(Pair(targetIndex, oldValue))
        }
    }
}