import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemSolvingTest {
    @Test
    void mixedPositiveNumbers() {
        assertEquals(9, ProblemSolving.findLargest(new int[]{3, 7, 2, 9, 4}));
    }

    @Test
    void allNegativeNumbers() {
        assertEquals(-3, ProblemSolving.findLargest(new int[]{-8, -3, -12}));
    }

    @Test
    void singleElement() {
        assertEquals(5, ProblemSolving.findLargest(new int[]{5}));
    }

    @Test
    void largestAtStart() {
        assertEquals(10, ProblemSolving.findLargest(new int[]{10, 4, 2}));
    }

    @Test
    void largestAtEnd() {
        assertEquals(10, ProblemSolving.findLargest(new int[]{2, 4, 10}));
    }

    @Test
    void repeatedLargest() {
        assertEquals(7, ProblemSolving.findLargest(new int[]{7, 2, 7}));
    }

    @Test
    void zeroAndNegatives() {
        assertEquals(0, ProblemSolving.findLargest(new int[]{-5, 0, -1}));
    }

    @Test
    void integerLimits() {
        assertEquals(Integer.MAX_VALUE, ProblemSolving.findLargest(
                new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}));
    }
}
