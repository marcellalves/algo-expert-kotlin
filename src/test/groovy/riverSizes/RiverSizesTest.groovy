package riverSizes

import spock.lang.Specification

class RiverSizesTest extends Specification {
    RiverSize riverSize = new RiverSize()

    def "should return river sizes"() {
        given:
        ArrayList<List<Integer>> input = [
                [1, 0, 0, 1, 0],
                [1, 0, 1, 0, 0],
                [0, 0, 1, 0, 1],
                [1, 0, 1, 0, 1],
                [1, 0, 1, 1, 0],
        ]

        when:
        List<Integer> actual = riverSize.riverSizes(input)

        then:
        actual == [2, 1, 5, 2, 2]
    }
}
