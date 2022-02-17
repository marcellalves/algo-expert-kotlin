package linkedLists

class LinkedList {
    private class Node (var value: Int) {
        var next: Node? = null
    }

    private var first: Node? = null
        get() = field
        private set(value) {
            field = value
        }
    private var last: Node? = null
        get() = field
        private set(value) {
            field = value
        }

    fun addFirst (value: Int) {
        val node = Node(value)

        if (first == null) {
            if (this.last == null) {
                this.last = node
            }
        } else {
            node.next = first!!
        }
        first = node
    }

    fun addLast (value: Int) {
        val node = Node(value)

        if (last == null) {
            this.first = node
        } else {
            last!!.next = node
        }

        last = node
    }

    fun deleteFirst () {
        this.first = first?.next
        if (this.first == null) {
            this.last = null
        }
    }

    fun deleteLast () {
        var currentNode = this.first
        while(currentNode != null) {
            if (currentNode.next == null) {
                this.last = null
                this.first = null
                break
            }

            if (currentNode.next?.next == null) {
                this.last = currentNode
                this.last!!.next = null
                break
            }
            currentNode = currentNode.next
        }
    }

    fun contains (value: Int): Boolean {
        var node = this.first

        while (node != null) {
            if (node.value == value) {
                return true
            }
            node = node.next
        }

        return false
    }

    fun indexOf (value: Int): Int {
        var node = this.first
        var index = -1

        while (node != null) {
            index++

            if (node.value == value) {
                return index
            }

            node = node.next
        }

        return -1
    }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        var node = this.first

        while (node != null) {
            if (node.next != null) {
                stringBuilder.append("${node.value} -> ")
            } else {
               stringBuilder.append(node.value)
            }
            node = node.next
        }

        return stringBuilder.toString()
    }
}
