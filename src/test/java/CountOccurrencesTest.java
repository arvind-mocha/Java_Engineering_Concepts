import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountOccurrencesTest {
    @Test
    void multipleMatches() {
        assertEquals(3, ProblemSolving.countOccurrences(new int[]{3, 7, 3, 9, 3, 4}, 3));
    }

    @Test
    void noMatches() {
        assertEquals(0, ProblemSolving.countOccurrences(new int[]{1, 2, 4}, 3));
    }

    @Test
    void emptyArray() {
        assertEquals(0, ProblemSolving.countOccurrences(new int[]{}, 3));
    }

    @Test
    void singleMatchingElement() {
        assertEquals(1, ProblemSolving.countOccurrences(new int[]{5}, 5));
    }

    @Test
    void singleNonMatchingElement() {
        assertEquals(0, ProblemSolving.countOccurrences(new int[]{5}, 2));
    }

    @Test
    void allElementsMatch() {
        assertEquals(4, ProblemSolving.countOccurrences(new int[]{7, 7, 7, 7}, 7));
    }

    @Test
    void negativeTarget() {
        assertEquals(2, ProblemSolving.countOccurrences(new int[]{-2, 3, -2, -5}, -2));
    }

    @Test
    void zeroTarget() {
        assertEquals(3, ProblemSolving.countOccurrences(new int[]{0, -1, 0, 2, 0}, 0));
    }

    @Test
    void matchesAtBothEnds() {
        assertEquals(2, ProblemSolving.countOccurrences(new int[]{4, 1, 2, 4}, 4));
    }

    @Test
    void integerLimits() {
        assertEquals(2, ProblemSolving.countOccurrences(
                new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}, Integer.MIN_VALUE));
    }
}
