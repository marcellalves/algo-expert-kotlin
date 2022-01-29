package validateSubsequence

class ValidateSubsequence {
    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        var i = 0
        var j = 0

        while (i < array.size && j < sequence.size) {
            if (array[i] == sequence[j]) {
                j++
            }
            i++
        }

        return j == sequence.size
    }
}
