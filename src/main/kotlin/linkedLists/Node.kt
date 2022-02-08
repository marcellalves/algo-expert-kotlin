package linkedLists

class Node (private var value: Int) {
    private var next: Node? = null

    fun getValue(): Int {
        return this.value
    }

    fun getNext(): Node? {
        return this.next
    }

    fun setNext(next: Node) {
        this.next = next
    }
}