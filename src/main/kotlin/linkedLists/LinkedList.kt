package linkedLists

class LinkedList () {
    var first: Node? = null
    var last: Node? = null

    fun addFirst (value: Int) {
        val node = Node(value)

        if (first == null) {
            if (this.last == null) {
                this.last = node
            }
        } else {
            node?.next = first!!
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
        var oldFirst = this.first
        this.first = first?.next
        oldFirst = null
    }
    //deleteLast
    //contains
    //indexOf

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
