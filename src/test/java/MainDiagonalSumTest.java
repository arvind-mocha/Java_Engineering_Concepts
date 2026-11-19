import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainDiagonalSumTest {
    @Test
    void threeByThree() {
        assertEquals(15, ProblemSolving.mainDiagonalSum(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }

    @Test
    void twoByTwo() {
        assertEquals(5, ProblemSolving.mainDiagonalSum(new int[][]{
                {1, 2}, {3, 4}
        }));
    }

    @Test
    void fourByFour() {
        assertEquals(34, ProblemSolving.mainDiagonalSum(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}
        }));
    }

    @Test
    void emptyMatrix() {
        assertEquals(0, ProblemSolving.mainDiagonalSum(new int[][]{}));
    }

    @Test
    void singleElement() {
        assertEquals(7, ProblemSolving.mainDiagonalSum(new int[][]{{7}}));
    }

    @Test
    void singleNegativeElement() {
        assertEquals(-7, ProblemSolving.mainDiagonalSum(new int[][]{{-7}}));
    }

    @Test
    void allNegative() {
        assertEquals(-15, ProblemSolving.mainDiagonalSum(new int[][]{
                {-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}
        }));
    }

    @Test
    void allZeros() {
        assertEquals(0, ProblemSolving.mainDiagonalSum(new int[][]{
                {0, 0}, {0, 0}
        }));
    }

    @Test
    void ignoresOffDiagonalValues() {
        assertEquals(0, ProblemSolving.mainDiagonalSum(new int[][]{
                {0, 100, 200}, {300, 0, 400}, {500, 600, 0}
        }));
    }

    @Test
    void repeatedValues() {
        assertEquals(3, ProblemSolving.mainDiagonalSum(new int[][]{
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        }));
    }

    @Test
    void mixedSignsOnDiagonal() {
        assertEquals(2, ProblemSolving.mainDiagonalSum(new int[][]{
                {-5, 8, 9}, {3, 0, 2}, {4, 6, 7}
        }));
    }

    @Test
    void doesNotModifyMatrix() {
        int[][] matrix = {{2, 9}, {8, 5}};
        assertEquals(7, ProblemSolving.mainDiagonalSum(matrix));
        assertArrayEquals(new int[]{2, 9}, matrix[0]);
        assertArrayEquals(new int[]{8, 5}, matrix[1]);
    }
}
