package validateSubsequence

import spock.lang.Specification

class ValidateSubsequenceTest extends Specification {
    ValidateSubsequence validateSubsequence = new ValidateSubsequence()

    def "should return true if an array is a subsequence of the other or false if it is not"() {
        given:
        List<Integer> array = [5, 1, 22, 25, 6, -1, 8, 10]
        List<Integer> sequence = [1, 6, -1, 10]

        when:
        Boolean actual = validateSubsequence.isValidSubsequence(array, sequence)

        then:
        actual == true
    }

    def "should return true if a single number is containe at the array"() {
        given:
        List<Integer> array = [5, 1, 22, 25, 6, -1, 8, 10]
        List<Integer> sequence = [8]

        when:
        Boolean actual = validateSubsequence.isValidSubsequence(array, sequence)

        then:
        actual == true
    }

    def "should return true if the arrays are the same"() {
        given:
        List<Integer> array = [5, 1, 22, 25, 6, -1, 8, 10]
        List<Integer> sequence = [5, 1, 22, 25, 6, -1, 8, 10]

        when:
        Boolean actual = validateSubsequence.isValidSubsequence(array, sequence)

        then:
        actual == true
    }
}
