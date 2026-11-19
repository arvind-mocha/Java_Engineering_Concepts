import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondaryDiagonalSumTest {
    @Test
    void threeByThree() {
        assertEquals(16, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {1, 2, 8}, {4, 5, 6}, {3, 7, 9}
        }));
    }

    @Test
    void twoByTwo() {
        assertEquals(10, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {1, 7}, {3, 4}
        }));
    }

    @Test
    void fourByFour() {
        assertEquals(34, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}
        }));
    }

    @Test
    void emptyMatrix() {
        assertEquals(0, ProblemSolving.secondaryDiagonalSum(new int[][]{}));
    }

    @Test
    void singleElement() {
        assertEquals(7, ProblemSolving.secondaryDiagonalSum(new int[][]{{7}}));
    }

    @Test
    void singleNegativeElement() {
        assertEquals(-7, ProblemSolving.secondaryDiagonalSum(new int[][]{{-7}}));
    }

    @Test
    void allNegative() {
        assertEquals(-16, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {-1, -2, -8}, {-4, -5, -6}, {-3, -7, -9}
        }));
    }

    @Test
    void allZeros() {
        assertEquals(0, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {0, 0}, {0, 0}
        }));
    }

    @Test
    void ignoresValuesOutsideSecondaryDiagonal() {
        assertEquals(0, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {100, 200, 0}, {300, 0, 400}, {0, 500, 600}
        }));
    }

    @Test
    void repeatedValues() {
        assertEquals(3, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        }));
    }

    @Test
    void mixedSignsOnDiagonal() {
        assertEquals(2, ProblemSolving.secondaryDiagonalSum(new int[][]{
                {8, 9, -5}, {3, 0, 2}, {7, 4, 6}
        }));
    }

    @Test
    void doesNotModifyMatrix() {
        int[][] matrix = {{2, 9}, {8, 5}};
        assertEquals(17, ProblemSolving.secondaryDiagonalSum(matrix));
        assertArrayEquals(new int[]{2, 9}, matrix[0]);
        assertArrayEquals(new int[]{8, 5}, matrix[1]);
    }
}
