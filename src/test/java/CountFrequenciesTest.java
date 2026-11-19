import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountFrequenciesTest {
    @Test
    void mixedFrequencies() {
        assertEquals(Map.of(4, 3, 1, 2, 2, 1),
                ProblemSolving.countFrequencies(new int[]{4, 1, 4, 2, 1, 4}));
    }

    @Test
    void emptyArray() {
        assertEquals(Map.of(), ProblemSolving.countFrequencies(new int[]{}));
    }

    @Test
    void singleElement() {
        assertEquals(Map.of(5, 1), ProblemSolving.countFrequencies(new int[]{5}));
    }

    @Test
    void allDistinct() {
        assertEquals(Map.of(3, 1, 1, 1, 7, 1),
                ProblemSolving.countFrequencies(new int[]{3, 1, 7}));
    }

    @Test
    void allEqual() {
        assertEquals(Map.of(7, 4), ProblemSolving.countFrequencies(new int[]{7, 7, 7, 7}));
    }

    @Test
    void allZeros() {
        assertEquals(Map.of(0, 3), ProblemSolving.countFrequencies(new int[]{0, 0, 0}));
    }

    @Test
    void negativeNumbers() {
        assertEquals(Map.of(-2, 2, -5, 1),
                ProblemSolving.countFrequencies(new int[]{-2, -5, -2}));
    }

    @Test
    void oppositeSignsAreDifferentKeys() {
        assertEquals(Map.of(-2, 2, 2, 1, 0, 2),
                ProblemSolving.countFrequencies(new int[]{-2, 2, 0, -2, 0}));
    }

    @Test
    void integerLimits() {
        assertEquals(Map.of(Integer.MIN_VALUE, 2, Integer.MAX_VALUE, 1),
                ProblemSolving.countFrequencies(new int[]{
                        Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE
                }));
    }

    @Test
    void nonAdjacentRepeats() {
        assertEquals(Map.of(1, 3, 2, 2, 3, 1),
                ProblemSolving.countFrequencies(new int[]{1, 2, 1, 3, 2, 1}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {4, 1, 4, 2};
        assertEquals(Map.of(4, 2, 1, 1, 2, 1), ProblemSolving.countFrequencies(numbers));
        assertArrayEquals(new int[]{4, 1, 4, 2}, numbers);
    }

    @Test
    void callsAreIndependent() {
        Map<Integer, Integer> first = ProblemSolving.countFrequencies(new int[]{1, 1, 2});
        Map<Integer, Integer> second = ProblemSolving.countFrequencies(new int[]{2, 3, 3});
        assertEquals(Map.of(1, 2, 2, 1), first);
        assertEquals(Map.of(2, 1, 3, 2), second);
    }
}
