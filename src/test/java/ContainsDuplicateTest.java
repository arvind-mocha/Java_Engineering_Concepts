import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {
    @Test
    void nonAdjacentDuplicate() {
        assertTrue(ProblemSolving.containsDuplicate(new int[]{4, 1, 7, 4, 2}));
    }

    @Test
    void allUniqueUnsorted() {
        assertFalse(ProblemSolving.containsDuplicate(new int[]{4, 1, 7, 2}));
    }

    @Test
    void emptyArray() {
        assertFalse(ProblemSolving.containsDuplicate(new int[]{}));
    }

    @Test
    void singleElement() {
        assertFalse(ProblemSolving.containsDuplicate(new int[]{5}));
    }

    @Test
    void twoEqualElements() {
        assertTrue(ProblemSolving.containsDuplicate(new int[]{2, 2}));
    }

    @Test
    void twoDifferentElements() {
        assertFalse(ProblemSolving.containsDuplicate(new int[]{2, 8}));
    }

    @Test
    void allEqual() {
        assertTrue(ProblemSolving.containsDuplicate(new int[]{7, 7, 7}));
    }

    @Test
    void repeatedZero() {
        assertTrue(ProblemSolving.containsDuplicate(new int[]{0, 3, -1, 0}));
    }

    @Test
    void repeatedNegative() {
        assertTrue(ProblemSolving.containsDuplicate(new int[]{-3, 2, -1, -3}));
    }

    @Test
    void oppositeSignsAreDistinct() {
        assertFalse(ProblemSolving.containsDuplicate(new int[]{-2, 2, 0}));
    }

    @Test
    void integerLimits() {
        assertFalse(ProblemSolving.containsDuplicate(
                new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}));
        assertTrue(ProblemSolving.containsDuplicate(
                new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }

    @Test
    void doesNotModifyInput() {
        int[] numbers = {3, 1, 2, 1};
        assertTrue(ProblemSolving.containsDuplicate(numbers));
        assertArrayEquals(new int[]{3, 1, 2, 1}, numbers);

        int[] uniqueNumbers = {3, 1, 2};
        assertFalse(ProblemSolving.containsDuplicate(uniqueNumbers));
        assertArrayEquals(new int[]{3, 1, 2}, uniqueNumbers);
    }
}
