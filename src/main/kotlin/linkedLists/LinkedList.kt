package linkedLists

class LinkedList () {
    private var first: Node? = null
    private var last: Node? = null

    fun addFirst (value: Int) {
        val node = Node(value)

        if (first == null) {
            if (last == null) {
                last = node
            }
        } else {
            node.setNext(first!!)
        }
        first = node
    }

    fun addLast (value: Int) {
        val node = Node(value)

        if (last == null) {
            first = node
        } else {
            last!!.setNext(node)
        }

        last = node
    }
    //deleteFirst
    //deleteLast
    //contains
    //indexOf

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        var node = this.first

        while (node != null) {
            if (node.getNext() != null) {
                stringBuilder.append("${node.getValue()} -> ")
            } else {
               stringBuilder.append(node.getValue())
            }
            node = node.getNext()
        }

        return stringBuilder.toString()
    }
}