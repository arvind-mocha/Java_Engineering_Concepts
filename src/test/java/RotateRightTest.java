import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateRightTest {
    @Test
    void oddLength() {
        int[] numbers = {1, 2, 3, 4, 5};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, numbers);
    }

    @Test
    void evenLength() {
        int[] numbers = {1, 2, 3, 4};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{4, 1, 2, 3}, numbers);
    }

    @Test
    void emptyArray() {
        int[] numbers = {};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{}, numbers);
    }

    @Test
    void singleElement() {
        int[] numbers = {5};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{5}, numbers);
    }

    @Test
    void twoElements() {
        int[] numbers = {8, 3};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{3, 8}, numbers);
    }

    @Test
    void repeatedValues() {
        int[] numbers = {2, 2, 3, 2};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{2, 2, 2, 3}, numbers);
    }

    @Test
    void allEqual() {
        int[] numbers = {7, 7, 7};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{7, 7, 7}, numbers);
    }

    @Test
    void negativesAndZero() {
        int[] numbers = {-3, 0, -1, 2};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{2, -3, 0, -1}, numbers);
    }

    @Test
    void zeroAtEnd() {
        int[] numbers = {4, 1, 0};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{0, 4, 1}, numbers);
    }

    @Test
    void integerLimits() {
        int[] numbers = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, numbers);
    }

    @Test
    void rotatingTwiceMovesTwoPositions() {
        int[] numbers = {1, 2, 3, 4, 5};
        ProblemSolving.rotateRight(numbers);
        ProblemSolving.rotateRight(numbers);
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, numbers);
    }

    @Test
    void fullCycleRestoresOriginal() {
        int[] numbers = {4, -1, 0, 7};
        for (int i = 0; i < numbers.length; i++) {
            ProblemSolving.rotateRight(numbers);
        }
        assertArrayEquals(new int[]{4, -1, 0, 7}, numbers);
    }
}
