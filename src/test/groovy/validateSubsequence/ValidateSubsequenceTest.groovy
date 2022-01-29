package validateSubsequence

import spock.lang.Specification

class ValidateSubsequenceTest extends Specification {
    ValidateSubsequence validateSubsequence = new ValidateSubsequence()

    def "Should return true if an array is a subsequence of the other or false if it is not"() {
        given:
        List<Integer> array = [5, 1, 22, 25, 6, -1, 8, 10]
        List<Integer> sequence = [1, 6, -1, 10]

        when:
        Boolean actual = validateSubsequence.isValidSubsequence(array, sequence)

        then:
        actual == true
    }
}
