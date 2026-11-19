import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZerosTest {
    @Test
    void mixedZerosAndNumbers() {
        int[] numbers = {0, 1, 0, 3, 12};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, numbers);
    }

    @Test
    void emptyArray() {
        int[] numbers = {};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{}, numbers);
    }

    @Test
    void singleZero() {
        int[] numbers = {0};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{0}, numbers);
    }

    @Test
    void singleNonZero() {
        int[] numbers = {5};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{5}, numbers);
    }

    @Test
    void allZeros() {
        int[] numbers = {0, 0, 0, 0};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{0, 0, 0, 0}, numbers);
    }

    @Test
    void noZeros() {
        int[] numbers = {4, -2, 7, 1};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{4, -2, 7, 1}, numbers);
    }

    @Test
    void leadingZeros() {
        int[] numbers = {0, 0, 3, 1};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{3, 1, 0, 0}, numbers);
    }

    @Test
    void trailingZeros() {
        int[] numbers = {3, 1, 0, 0};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{3, 1, 0, 0}, numbers);
    }

    @Test
    void consecutiveZerosInMiddle() {
        int[] numbers = {3, 0, 0, 1, 0, 0, 2};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{3, 1, 2, 0, 0, 0, 0}, numbers);
    }

    @Test
    void preservesOrderAndDuplicates() {
        int[] numbers = {4, 0, -2, 0, 4};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{4, -2, 4, 0, 0}, numbers);
    }

    @Test
    void integerLimits() {
        int[] numbers = {0, Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0}, numbers);
    }

    @Test
    void runningTwiceKeepsSameResult() {
        int[] numbers = {0, 2, 0, 1};
        ProblemSolving.moveZeros(numbers);
        ProblemSolving.moveZeros(numbers);
        assertArrayEquals(new int[]{2, 1, 0, 0}, numbers);
    }
}
