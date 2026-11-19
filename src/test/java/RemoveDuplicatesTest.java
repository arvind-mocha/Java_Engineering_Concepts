import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesTest {
    private void assertUniquePrefix(int[] numbers, int... expected) {
        int count = ProblemSolving.removeDuplicates(numbers);
        assertEquals(expected.length, count, "Unique count");
        for (int i = 0; i < count; i++) {
            assertEquals(expected[i], numbers[i], "Value at index " + i);
        }
        // Values after the unique prefix are deliberately not checked.
    }

    @Test
    void mixedDuplicateGroups() {
        assertUniquePrefix(new int[]{1, 1, 2, 2, 3, 4, 4}, 1, 2, 3, 4);
    }

    @Test
    void emptyArray() {
        assertUniquePrefix(new int[]{});
    }

    @Test
    void singleElement() {
        assertUniquePrefix(new int[]{5}, 5);
    }

    @Test
    void allEqual() {
        assertUniquePrefix(new int[]{5, 5, 5, 5}, 5);
    }

    @Test
    void allUnique() {
        assertUniquePrefix(new int[]{1, 2, 3, 4}, 1, 2, 3, 4);
    }

    @Test
    void twoEqualElements() {
        assertUniquePrefix(new int[]{2, 2}, 2);
    }

    @Test
    void twoDifferentElements() {
        assertUniquePrefix(new int[]{2, 8}, 2, 8);
    }

    @Test
    void duplicatesAtStart() {
        assertUniquePrefix(new int[]{1, 1, 1, 2, 3}, 1, 2, 3);
    }

    @Test
    void duplicatesAtEnd() {
        assertUniquePrefix(new int[]{1, 2, 3, 3, 3}, 1, 2, 3);
    }

    @Test
    void negativesAndZero() {
        assertUniquePrefix(new int[]{-5, -5, -2, 0, 0, 3}, -5, -2, 0, 3);
    }

    @Test
    void allZeros() {
        assertUniquePrefix(new int[]{0, 0, 0}, 0);
    }

    @Test
    void integerLimits() {
        assertUniquePrefix(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 0,
                Integer.MAX_VALUE, Integer.MAX_VALUE}, Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
    }
}
