import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BothDiagonalsSumTest {
    @Test
    void oddSizeCountsCenterOnce() {
        assertEquals(26, ProblemSolving.bothDiagonalsSum(new int[][]{
                {1, 2, 8}, {4, 5, 6}, {3, 7, 9}
        }));
    }

    @Test
    void twoByTwo() {
        assertEquals(10, ProblemSolving.bothDiagonalsSum(new int[][]{
                {1, 2}, {3, 4}
        }));
    }

    @Test
    void evenSizeHasNoSharedCenter() {
        assertEquals(68, ProblemSolving.bothDiagonalsSum(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}
        }));
    }

    @Test
    void emptyMatrix() {
        assertEquals(0, ProblemSolving.bothDiagonalsSum(new int[][]{}));
    }

    @Test
    void singleElementCountsOnce() {
        assertEquals(7, ProblemSolving.bothDiagonalsSum(new int[][]{{7}}));
    }

    @Test
    void negativeCenterCountsOnce() {
        assertEquals(6, ProblemSolving.bothDiagonalsSum(new int[][]{
                {1, 0, 2}, {0, -4, 0}, {3, 0, 4}
        }));
    }

    @Test
    void allNegative() {
        assertEquals(-25, ProblemSolving.bothDiagonalsSum(new int[][]{
                {-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}
        }));
    }

    @Test
    void allZeros() {
        assertEquals(0, ProblemSolving.bothDiagonalsSum(new int[][]{
                {0, 0}, {0, 0}
        }));
    }

    @Test
    void ignoresPositionsOutsideBothDiagonals() {
        assertEquals(0, ProblemSolving.bothDiagonalsSum(new int[][]{
                {0, 100, 0}, {200, 0, 300}, {0, 400, 0}
        }));
    }

    @Test
    void equalValuesAtDifferentPositionsCountSeparately() {
        assertEquals(5, ProblemSolving.bothDiagonalsSum(new int[][]{
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        }));
    }

    @Test
    void fiveByFive() {
        assertEquals(117, ProblemSolving.bothDiagonalsSum(new int[][]{
                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        }));
    }

    @Test
    void doesNotModifyMatrix() {
        int[][] matrix = {{2, 9}, {8, 5}};
        assertEquals(24, ProblemSolving.bothDiagonalsSum(matrix));
        assertArrayEquals(new int[]{2, 9}, matrix[0]);
        assertArrayEquals(new int[]{8, 5}, matrix[1]);
    }
}
