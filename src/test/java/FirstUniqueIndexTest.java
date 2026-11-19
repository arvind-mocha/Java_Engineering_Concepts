import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueIndexTest {
    @Test
    void mixedFrequencies() {
        assertEquals(3, ProblemSolving.firstUniqueIndex(new int[]{4, 1, 4, 2, 1, 7}));
    }

    @Test
    void emptyArray() {
        assertEquals(-1, ProblemSolving.firstUniqueIndex(new int[]{}));
    }

    @Test
    void singleElement() {
        assertEquals(0, ProblemSolving.firstUniqueIndex(new int[]{5}));
    }

    @Test
    void originalOrderMatters() {
        assertEquals(0, ProblemSolving.firstUniqueIndex(new int[]{9, 1, 4}));
    }

    @Test
    void noUniqueElements() {
        assertEquals(-1, ProblemSolving.firstUniqueIndex(new int[]{2, 1, 2, 1}));
    }

    @Test
    void uniqueAtEnd() {
        assertEquals(2, ProblemSolving.firstUniqueIndex(new int[]{2, 2, 5}));
    }

    @Test
    void earlyElementRepeatsLater() {
        assertEquals(1, ProblemSolving.firstUniqueIndex(new int[]{8, 3, 8, 4}));
    }

    @Test
    void zeroCanBeUnique() {
        assertEquals(1, ProblemSolving.firstUniqueIndex(new int[]{1, 0, 1}));
    }

    @Test
    void negativeNumbers() {
        assertEquals(1, ProblemSolving.firstUniqueIndex(new int[]{-2, -1, -2}));
    }

    @Test
    void countsGreaterThanTwo() {
        assertEquals(5, ProblemSolving.firstUniqueIndex(new int[]{3, 3, 3, 5, 5, 7}));
    }

    @Test
    void integerLimits() {
        assertEquals(1, ProblemSolving.firstUniqueIndex(new int[]{
                Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE
        }));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {4, 1, 4, 2};
        assertEquals(1, ProblemSolving.firstUniqueIndex(numbers));
        assertArrayEquals(new int[]{4, 1, 4, 2}, numbers);
    }
}
