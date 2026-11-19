import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateMatrixClockwiseTest {
    private void assertRowsEqual(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int row = 0; row < expected.length; row++) {
            assertArrayEquals(expected[row], actual[row], "Row " + row);
        }
    }

    @Test
    void threeByThree() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, matrix);
    }

    @Test
    void twoByTwo() {
        int[][] matrix = {{1, 2}, {3, 4}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{3, 1}, {4, 2}}, matrix);
    }

    @Test
    void fourByFour() {
        int[][] matrix = {
                {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}
        };
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{
                {13, 9, 5, 1}, {14, 10, 6, 2},
                {15, 11, 7, 3}, {16, 12, 8, 4}
        }, matrix);
    }

    @Test
    void emptyMatrix() {
        int[][] matrix = {};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{}, matrix);
    }

    @Test
    void singleElement() {
        int[][] matrix = {{7}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{7}}, matrix);
    }

    @Test
    void allZeros() {
        int[][] matrix = {{0, 0}, {0, 0}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{0, 0}, {0, 0}}, matrix);
    }

    @Test
    void diagonalMovesToSecondaryDiagonal() {
        int[][] matrix = {{4, 0, 0}, {0, -7, 0}, {0, 0, 2}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{0, 0, 4}, {0, -7, 0}, {2, 0, 0}}, matrix);
    }

    @Test
    void negativesAndZero() {
        int[][] matrix = {{-1, 0, 2}, {3, -4, 0}, {-5, 6, -7}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{-5, 3, -1}, {6, -4, 0}, {-7, 0, 2}}, matrix);
    }

    @Test
    void repeatedValues() {
        int[][] matrix = {{1, 1}, {2, 2}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{2, 1}, {2, 1}}, matrix);
    }

    @Test
    void integerLimits() {
        int[][] matrix = {{0, Integer.MIN_VALUE}, {Integer.MAX_VALUE, 1}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{Integer.MAX_VALUE, 0}, {1, Integer.MIN_VALUE}}, matrix);
    }

    @Test
    void rotatingTwiceTurns180Degrees() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ProblemSolving.rotateMatrixClockwise(matrix);
        ProblemSolving.rotateMatrixClockwise(matrix);
        assertRowsEqual(new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, matrix);
    }

    @Test
    void fourRotationsRestoreOriginal() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 4; i++) {
            ProblemSolving.rotateMatrixClockwise(matrix);
        }
        assertRowsEqual(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, matrix);
    }
}
