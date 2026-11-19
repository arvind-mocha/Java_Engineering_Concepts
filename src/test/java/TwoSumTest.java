import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    private void assertValidPair(int[] numbers, int target) {
        int[] original = numbers.clone();
        int[] indices = ProblemSolving.twoSum(numbers, target);
        assertNotNull(indices);
        assertEquals(2, indices.length, "Return exactly two indices");
        assertTrue(indices[0] >= 0 && indices[0] < numbers.length, "First index in bounds");
        assertTrue(indices[1] >= 0 && indices[1] < numbers.length, "Second index in bounds");
        assertNotEquals(indices[0], indices[1], "Use two different positions");
        assertEquals(target, original[indices[0]] + original[indices[1]]);
        assertArrayEquals(original, numbers, "Do not modify input");
    }

    private void assertNoPair(int[] numbers, int target) {
        int[] original = numbers.clone();
        assertArrayEquals(new int[0], ProblemSolving.twoSum(numbers, target));
        assertArrayEquals(original, numbers, "Do not modify input");
    }

    @Test
    void samplePair() {
        assertValidPair(new int[]{2, 7, 11, 15}, 9);
    }

    @Test
    void emptyArray() {
        assertNoPair(new int[]{}, 5);
    }

    @Test
    void singleElementCannotPairWithItself() {
        assertNoPair(new int[]{3}, 6);
    }

    @Test
    void equalValuesAtDifferentIndices() {
        assertValidPair(new int[]{3, 3}, 6);
    }

    @Test
    void noSolution() {
        assertNoPair(new int[]{1, 2, 4}, 8);
    }

    @Test
    void cannotReuseAnIndexInLargerArray() {
        assertNoPair(new int[]{3, 4}, 6);
    }

    @Test
    void negativeTarget() {
        assertValidPair(new int[]{-3, -2, -5}, -8);
    }

    @Test
    void twoZeros() {
        assertValidPair(new int[]{0, 4, 0}, 0);
    }

    @Test
    void oppositeSigns() {
        assertValidPair(new int[]{-3, 4, 3, 90}, 0);
    }

    @Test
    void unsortedInput() {
        assertValidPair(new int[]{8, 2, 6, 3}, 9);
    }

    @Test
    void anyValidPairIsAccepted() {
        assertValidPair(new int[]{1, 2, 3, 4}, 5);
    }

    @Test
    void valuesAtAllowedLimits() {
        assertValidPair(new int[]{1_000_000, 7, -1_000_000}, 0);
    }
}
