import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSortedTest {
    @Test
    void ascendingWithDuplicates() {
        assertTrue(ProblemSolving.isSorted(new int[]{1, 2, 2, 4, 7}));
    }

    @Test
    void decreaseInMiddle() {
        assertFalse(ProblemSolving.isSorted(new int[]{1, 4, 3, 7}));
    }

    @Test
    void emptyArray() {
        assertTrue(ProblemSolving.isSorted(new int[]{}));
    }

    @Test
    void singleElement() {
        assertTrue(ProblemSolving.isSorted(new int[]{5}));
    }

    @Test
    void twoElements() {
        assertTrue(ProblemSolving.isSorted(new int[]{2, 8}));
        assertFalse(ProblemSolving.isSorted(new int[]{8, 2}));
    }

    @Test
    void allEqual() {
        assertTrue(ProblemSolving.isSorted(new int[]{7, 7, 7}));
    }

    @Test
    void decreaseAtStart() {
        assertFalse(ProblemSolving.isSorted(new int[]{3, 1, 2, 4}));
    }

    @Test
    void decreaseAtEnd() {
        assertFalse(ProblemSolving.isSorted(new int[]{1, 2, 4, 3}));
    }

    @Test
    void descendingArray() {
        assertFalse(ProblemSolving.isSorted(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void negativesAndZero() {
        assertTrue(ProblemSolving.isSorted(new int[]{-9, -3, -3, 0, 2}));
        assertFalse(ProblemSolving.isSorted(new int[]{-1, -5, 0}));
    }

    @Test
    void integerLimits() {
        assertTrue(ProblemSolving.isSorted(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}));
        assertFalse(ProblemSolving.isSorted(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {3, 1, 2};
        assertFalse(ProblemSolving.isSorted(numbers));
        assertArrayEquals(new int[]{3, 1, 2}, numbers);
    }
}
