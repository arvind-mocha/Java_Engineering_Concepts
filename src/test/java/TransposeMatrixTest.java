import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TransposeMatrixTest {
    private void assertRowsEqual(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int row = 0; row < expected.length; row++) {
            assertArrayEquals(expected[row], actual[row], "Row " + row);
        }
    }

    @Test
    void threeByThree() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, matrix);
    }

    @Test
    void twoByTwo() {
        int[][] matrix = {{1, 2}, {3, 4}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{1, 3}, {2, 4}}, matrix);
    }

    @Test
    void fourByFour() {
        int[][] matrix = {
                {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}
        };
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{
                {1, 5, 9, 13}, {2, 6, 10, 14},
                {3, 7, 11, 15}, {4, 8, 12, 16}
        }, matrix);
    }

    @Test
    void emptyMatrix() {
        int[][] matrix = {};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{}, matrix);
    }

    @Test
    void singleElement() {
        int[][] matrix = {{7}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{7}}, matrix);
    }

    @Test
    void allZeros() {
        int[][] matrix = {{0, 0}, {0, 0}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{0, 0}, {0, 0}}, matrix);
    }

    @Test
    void diagonalMatrixStaysUnchanged() {
        int[][] matrix = {{4, 0, 0}, {0, -7, 0}, {0, 0, 2}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{4, 0, 0}, {0, -7, 0}, {0, 0, 2}}, matrix);
    }

    @Test
    void symmetricMatrixStaysUnchanged() {
        int[][] matrix = {{1, 2, 3}, {2, 4, 5}, {3, 5, 6}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{1, 2, 3}, {2, 4, 5}, {3, 5, 6}}, matrix);
    }

    @Test
    void negativesAndZero() {
        int[][] matrix = {{-1, 0, 2}, {3, -4, 0}, {-5, 6, -7}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{-1, 3, -5}, {0, -4, 6}, {2, 0, -7}}, matrix);
    }

    @Test
    void upperTriangleBecomesLowerTriangle() {
        int[][] matrix = {{1, 2, 3}, {0, 4, 5}, {0, 0, 6}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{1, 0, 0}, {2, 4, 0}, {3, 5, 6}}, matrix);
    }

    @Test
    void integerLimits() {
        int[][] matrix = {{0, Integer.MIN_VALUE}, {Integer.MAX_VALUE, 1}};
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{0, Integer.MAX_VALUE}, {Integer.MIN_VALUE, 1}}, matrix);
    }

    @Test
    void transposingTwiceRestoresOriginal() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ProblemSolving.transposeMatrix(matrix);
        ProblemSolving.transposeMatrix(matrix);
        assertRowsEqual(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, matrix);
    }
}
