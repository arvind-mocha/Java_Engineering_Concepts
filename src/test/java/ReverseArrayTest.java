import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseArrayTest {
    @Test
    void oddLength() {
        int[] numbers = {1, 2, 3, 4, 5};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, numbers);
    }

    @Test
    void evenLength() {
        int[] numbers = {1, 2, 3, 4};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{4, 3, 2, 1}, numbers);
    }

    @Test
    void emptyArray() {
        int[] numbers = {};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{}, numbers);
    }

    @Test
    void singleElement() {
        int[] numbers = {5};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{5}, numbers);
    }

    @Test
    void twoElements() {
        int[] numbers = {8, 3};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{3, 8}, numbers);
    }

    @Test
    void repeatedValues() {
        int[] numbers = {2, 2, 3, 2};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{2, 3, 2, 2}, numbers);
    }

    @Test
    void allEqual() {
        int[] numbers = {7, 7, 7};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{7, 7, 7}, numbers);
    }

    @Test
    void negativesAndZero() {
        int[] numbers = {-3, 0, -1, 2};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{2, -1, 0, -3}, numbers);
    }

    @Test
    void integerLimits() {
        int[] numbers = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}, numbers);
    }

    @Test
    void reversingTwiceRestoresOriginal() {
        int[] numbers = {4, -1, 0, 7, 2};
        ProblemSolving.reverseArray(numbers);
        ProblemSolving.reverseArray(numbers);
        assertArrayEquals(new int[]{4, -1, 0, 7, 2}, numbers);
    }
}
